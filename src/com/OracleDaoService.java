package com;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import utils.CommonUtil;

public class OracleDaoService {
	
	private Connection conn = OraClient.getConnection();
	
	Logger logger = Logger.getLogger(OracleDaoService.class);
	public void saveRecordToSQL(Vehicle v){
		try {
			String sql = "INSERT INTO V_WFCL(TOLLNO,LANENO,DIRECTION,PLATENO," +
					"PLATECOLOR,WFLX,VEHCSPEED,PASSTIME,VEHCCOLOR,VEHCLENGTH,RKSJ,WFTP) " +
					"values(?,?,?,?,?,?,?,?,?,?,?,?)";
			
//				conn.setAutoCommit(false);
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, v.getEsId());
				int lin =  Integer.parseInt(v.getDirLine());
				ps.setInt(2, lin);//Number
				ps.setString(3, v.getDirection());
				ps.setString(4, v.getPlate());
				ps.setString(5, v.getPlateClor());
				ps.setString(6, v.getIllegalType());
				
				int speed = Integer.parseInt(v.getSpeed());
				ps.setInt(7, speed);//number
				
				java.sql.Date passtime = CommonUtil.getDateFomate(v.getIllegalDate());
				
				logger.info("[passtime:]"+passtime);
				ps.setDate(8, passtime);
				ps.setString(9, v.getVehicleCorlor());
				ps.setInt(10,0);//number
				Date ut = CommonUtil.getDateFomate(v.getUpdateTime());
				ps.setDate(11,ut);//Date
				ps.setBlob(12, v.getImgBlob().getBinaryStream());
			    int rs = ps.executeUpdate();
//			    conn.commit();
			    ps.close();
			     
				logger.info("【执行插入数据库】"+rs);  
			} catch (SQLException e) {
				logger.error("【插入数据库报错】"+e.getMessage());
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			

	}
}
