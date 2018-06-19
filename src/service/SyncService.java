package service;

import java.util.Date;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHitField;
import org.elasticsearch.search.SearchHits;

import utils.Base64Img;
import utils.CommonUtil;
import utils.KksbMap;

import com.DaoService;
import com.EsManager;
import com.Vehicle;
import com.alibaba.fastjson.JSONObject;
import com.pcm.ws.jws.JupiterService;
import com.pcm.ws.jws.JupiterServiceSoap;

public class SyncService {
	
	private EsManager em = new EsManager();
	private DaoService daoService = new DaoService();
	
	private Logger logger=Logger.getLogger(SyncService.class);
	private String lastUpdateTime;
	public 	int nullDateCount = 0;
	private Date now =new Date();
	private int conf = 90;
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
			//打电话
			response = em.searchVFList(startTime,conf);
		}
		else if("1240".equals(illegalType)){
			//安全带
			response = em.searchAQDList(startTime,conf);
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
//        	logger.info("【ES获取的原始数据为】:"+jb);
        	
			String F_SBBH = jb.getString("F_SBBH");//卡口编号
			String F_CDFX = jb.getString("F_CDFX");
			String F_CDBH = jb.getString("F_CDBH");//车道编号
			String F_START_TIME = jb.getString("F_START_TIME");
			String F_HPHM = jb.getString("F_HPHM");
			String F_VEH_TYPE = jb.getString("F_VEH_TYPE");
			String F_VEH_SPEED = jb.getString("F_VEH_SPEED");
			String F_PIC_PATH1 = jb.getString("F_PIC_PATH1");
			String F_JLBH = jb.getString("F_JLBH");
			String F_PLATE_COLOR = jb.getString("F_PLATE_COLOR");
			
			F_SBBH = KksbMap.KDPointsDD.get(F_SBBH);
			
			if(!CommonUtil.isNotEmpty(F_SBBH) || !CommonUtil.isNotEmpty(F_HPHM) ||
					 !CommonUtil.isNotEmpty(F_PIC_PATH1) ){
				logger.error(F_SBBH+"[SBBH F_HPHM ]映射空"+",:"+F_HPHM+",F_PIC_PATH1:"+F_PIC_PATH1);
				continue;
			}
			
			int cdh = 1;  
			int clsd = 0;//车辆速度
			lastUpdateTime = F_START_TIME;
			if(F_CDBH !=null && "".equals(F_CDBH))
				cdh = Integer.parseInt(F_CDBH);
			if(F_VEH_SPEED !=null && "".equals(F_VEH_SPEED))
				clsd = Integer.parseInt(F_VEH_SPEED);
			
			String tgsk  = "1990-01-01 00:00:00.000";
			if(F_START_TIME != null && !"".equals(F_START_TIME)) tgsk  =F_START_TIME;  
			tgsk = tgsk.replace("-", "");
			tgsk = tgsk.replace(":", "");
			tgsk = tgsk.replace(".", ""); 
			tgsk = tgsk.replace(" ", "");
			
			logger.info("【过车时间：】"+tgsk); 
			
			String plate_type = "99";// 小型车
			if("2".equals(F_PLATE_COLOR)) plate_type = "02";
			else if("1".equals(F_PLATE_COLOR)) plate_type = "01";
			else if("3".equals(F_PLATE_COLOR)) plate_type = "06";
			String CarPic =  "";
			try{
				CarPic = Base64Img.Image2Base64(F_PIC_PATH1);
			}catch (Exception e) {
				logger.error("【图片异常，继续：】"+F_PIC_PATH1); 
				continue;  
			}
			if(!CommonUtil.isNotEmpty(CarPic)) { 
				logger.error("【图片访问不了，继续：】"+F_PIC_PATH1);   
				continue;
			}
			
			String xsfx = KksbMap.KDPointsFx.get(F_SBBH);
			if(!CommonUtil.isNotEmpty(xsfx)) xsfx = "1";
			
			String cip = KksbMap.KDPointsIp.get(F_SBBH);
			if(!CommonUtil.isNotEmpty(cip)) cip = "0.0.0.0";
			
			
			JupiterService service = new JupiterService();
			JupiterServiceSoap soap = 	service.getJupiterServiceSoap();
			logger.info("【------发送参数:】"+",F_SBBH:"+F_SBBH+",tgsk:"+tgsk+",F_HPHM:"+F_HPHM
					+",F_PLATE_COLOR:"+F_PLATE_COLOR+",plate_type:"+plate_type+",wflx:"+illegalType
					+",cip:"+cip+",clsd:"+clsd+",xsfx:"+xsfx);
			 
			String resultR = soap.sendAlarmPass(F_SBBH,F_SBBH,
					cdh,tgsk,F_HPHM,
					F_PLATE_COLOR,plate_type,illegalType,
					cip,clsd,xsfx,CarPic,"0");
			logger.info(F_SBBH+"返回结果集："+resultR);
//			Object[] paramValues = new Object[] {
////		"KKMY","KKBH",CDH(int),"TGSK(20180515101318000)","HPHM","HPYS","HPZL","WFDM","CarmerIP",CLSD,"XSFX","CarPic","0"	
//					F_SBBH,F_SBBH,cdh,tgsk,F_HPHM,F_PLATE_COLOR,plate_type,illegalType,cip,clsd,xsfx,CarPic,"0"
//			};  
			 
			Vehicle v = new Vehicle();
			v.setIllegalType(illegalType);
			v.setIllegalPlace(F_SBBH);
			v.setDirection("1");
			v.setDirLine(""+cdh);
			v.setIllegalDate(CommonUtil.getTimeStringPic(F_START_TIME));
			v.setPlate(F_HPHM);
			v.setDirection(xsfx);
			v.setImgIndex(cip);
			
			v.setSpeed(""+clsd);//F_VEH_SPEED
			v.setImgUrl(F_PIC_PATH1);
			 
			v.setUpdateTime(CommonUtil.getTimeString(now));
			v.setEsId(F_JLBH);
			
			if(F_PIC_PATH1 != null && F_HPHM != null ){
				logger.info("准备传送数据 图片...."+F_HPHM);
//				WSAxisService.WService(paramValues);
				daoService.saveRecordToSQL(v);//存数据库
		        daoService.upSyncTime(lastUpdateTime,illegalType);
			}
			
//        	logger.info(v.getPlate()+"【上传存储成功】:"+v.getPname());
        } 

        return nullDateCount;
	}
}
