package service;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.log4j.Logger;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHitField;
import org.elasticsearch.search.SearchHits;
import org.hibernate.Hibernate;

import utils.CommonUtil;
import utils.SqlString;
import utils.TsclSbbh;

import com.DaoService;
import com.EsManager;
import com.FTPClientKD;
import com.OracleDaoService;
import com.PointStaticMap;
import com.SQLiteJDBC;
import com.Vehicle;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;

public class SyncService {
	
	private EsManager em = new EsManager();
	private DaoService daoService = new DaoService();
	private OracleDaoService ocs = new OracleDaoService();
	private Logger logger=Logger.getLogger(SyncService.class);
	private String lastUpdateTime;
	public 	int nullDateCount = 0;
	private Date now =new Date();
	private int conf = 96;
	private String illegalType="";
	
	public SyncService(String ity){
		illegalType = ity;
		conf = daoService.getConfByTpye(illegalType);
	}
	
	public int startService(){
		logger.info("【---------同步服务开始-----------】"+illegalType);
		String startTime=  daoService.getUpdateTime(illegalType);
		SearchResponse response = null ;
		if("1223".equals(illegalType)){
			response = em.searchVFList(startTime,conf);
		}
		else if("6011".equals(illegalType)){
			response = em.searchAQDList(startTime,conf);
		}
		else if("0000".equals(illegalType)){
			response = em.searchWSJList(startTime,conf);
		}
		else if("1111".equals(illegalType)){
			response = em.searchTZCLList(startTime,conf);
		}
		else {
			return 200;
		}
        SearchHits hits = response.getHits(); 
        long total = hits.getTotalHits(); 
        SearchHit[] searchHits = hits.hits();
        System.out.println("【1获取】总数"+total+",length:"+searchHits.length); 
        if(total == 0){
        	nullDateCount ++;
        }
        
        for(SearchHit s : searchHits) 
        {       	
        	Set<Entry<String, SearchHitField>>  fieldEntry = s.getFields().entrySet();
        	JSONObject jb = new JSONObject();
        	for( Entry<String, SearchHitField> en : fieldEntry){
        		jb.put(en.getValue().getName(),en.getValue().getValue());
        	}
        	logger.info("【ES获取的原始数据为】:"+jb);
        	
			String F_SBBH = jb.getString("F_SBBH");
			String F_CDFX = jb.getString("F_CDFX");
			String F_CDBH = jb.getString("F_CDBH");
			String F_START_TIME = jb.getString("F_START_TIME");
			String F_HPHM = jb.getString("F_PLATE_NAME");
			String F_VEH_TYPE = jb.getString("F_VEH_TYPE");
			String F_VEH_SPEED = jb.getString("F_VEH_SPEED");
			String F_PIC_PATH1 = jb.getString("F_PIC_PATH1");
			String F_JLBH = jb.getString("F_JLBH");
			String F_HPYS = jb.getString("F_PLATE_COLOR");
			
			String F_VEH_COLOR = jb.getString("F_VEH_COLOR");
			String F_OBJ_ID = jb.getString("F_OBJ_ID");
			String F_HOLD_PHONE = jb.getString("F_HOLD_PHONE");
			String F_VECHILE_SPECIAL_TYPE = jb.getString("F_VECHILE_SPECIAL_TYPE");

			
			lastUpdateTime = F_START_TIME;
			
			Vehicle v = new Vehicle();
			v.setIllegalType(illegalType);
			
//			String hksb = PointStaticMap.points.get(F_SBBH);
			v.setIllegalPlace(F_SBBH);
			v.setDirection(F_CDFX);
			v.setDirLine(F_CDBH);
			v.setIllegalDate(CommonUtil.getTimeStringCommon(F_START_TIME));
			
			if(F_HPHM == null ){
				continue;
			}
			else if("0".equals(F_HPHM.substring(0,1))){
				continue;
			}
			v.setPlate(F_HPHM);
			if(F_VEH_TYPE!= null && !"".equals(F_VEH_TYPE)){
				if(F_VEH_TYPE.length() == 1){ v.setVehicleType("0"+F_VEH_TYPE); }
				else{ v.setVehicleType(F_VEH_TYPE); }
			}
			else{
				v.setVehicleType("00");
			}
			v.setSpeed(F_VEH_SPEED);//F_VEH_SPEED
			v.setMaxSpeed("60");
			v.setImgUrl(F_PIC_PATH1);
			v.setImgIndex("1");
			
			v.setUpdateTime(CommonUtil.getTimeString(now));
			v.setEsId(F_SBBH);
			v.setPname(v.getPname());
			
			v.setPlateClor(F_HPYS);
			v.setVehicleCorlor(F_VEH_COLOR);
			
			//特殊车辆
			if("1111".equals(illegalType) && F_VECHILE_SPECIAL_TYPE != null && !"".equals(F_VECHILE_SPECIAL_TYPE)){

				if("5".equals(F_VECHILE_SPECIAL_TYPE) || "6".equals(F_VECHILE_SPECIAL_TYPE) || "7".equals(F_VECHILE_SPECIAL_TYPE)
						|| "8".equals(F_VECHILE_SPECIAL_TYPE) || "9".equals(F_VECHILE_SPECIAL_TYPE) ||"10".equals(F_VECHILE_SPECIAL_TYPE)
						||"18".equals(F_VECHILE_SPECIAL_TYPE) ||"19".equals(F_VECHILE_SPECIAL_TYPE) ){
					if(!TsclSbbh.TSSB.contains(F_SBBH)){
						continue;
					}
				}
				else if("20".equals(F_VECHILE_SPECIAL_TYPE)){
					//其中厢式货车只对接高峰期（7:00-9:00,16:30-18:30）的数据。
					if(TsclSbbh.TSSB.contains(F_SBBH)){
						if(!CommonUtil.isWfSd(F_START_TIME)){
							continue;
						}
						else{
							v.setIllegalType("1911");
						}
					}
					else{
						continue;
					}
				}
				else{
					continue;
				}
				
			}

			if(F_PIC_PATH1 != null && F_HPHM != null ){
				logger.info("准备存储图片...."+F_HPHM);
				daoService.saveRecordToSQL(v);//存数据库
				try{
					Blob imgb = getBlobFfomUrl(F_PIC_PATH1);
					v.setImgBlob(imgb);
					logger.info("【转换获取BLOB】"+imgb.length());
					ocs.saveRecordToSQL(v);
				}
				catch (Exception e) {
					logger.info("【存Oracle失败】");
					// TODO: handle exception
				}
		        daoService.upSyncTime(lastUpdateTime,illegalType);
			}
			
        	logger.info(v.getPlate()+"【上传存储成功】:"+v.getPname());
        }

        return nullDateCount;
	}
	
	public Blob getBlobFfomUrl(String ur) throws IOException{
		URL url = new URL(ur);
		Blob img = Hibernate.createBlob(url.openStream());
		return img;
	}
	
}
