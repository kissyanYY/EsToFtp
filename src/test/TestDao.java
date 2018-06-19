package test;

import java.io.IOException;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.Hibernate;

import utils.CommonUtil;

import com.OraClient;
import com.SQLiteJDBC;
import com.Vehicle;

public class TestDao {
	
	public static void main(String[] args) throws Exception {
		Connection con = OraClient.getConnection();
		con.setAutoCommit(false);
		TestDao dd = new TestDao();
		Vehicle v = new Vehicle();
		v.setEsId("2");
		v.setDirLine("2");
		v.setDirection("W");
		v.setPlate("aa");
		v.setPlateClor("bb");
		v.setIllegalType("aaa");
		v.setSpeed("80");
		v.setIllegalDate("2017-12-12 00:00:00");
		v.setVehicleCorlor("a");
		v.setVehLength("0");
		
		
		String url = "http://172.21.229.84:8090/jpgs/519029780702-20170501090036-1-1.jpg";

		Blob imgBlob = getBlobFfomUrl(url);
		v.setImgBlob(imgBlob);
		dd.saveRecordToSQL(con,v);
		
	}
	
	
	public static Blob getBlobFfomUrl(String ur) throws IOException{
		URL url = new URL(ur);
		Blob img = Hibernate.createBlob(url.openStream());
		return img;
	}
	
	public void saveRecordToSQL(Connection conn ,Vehicle v){
		try {
//			String sql = "INSERT INTO V_WFCL(TOLLNO,LANENO,DIRECTION,PLATENO," +
//					"PLATECOLOR,WFLX,VEHCSPEED,PASSTIME,VEHCCOLOR,VEHCLENGTH,WFTP,RKSJ) " +
//					"values(?,?,?,?,?,?,?,?,?,?,?,?)";
			
			String sql = "INSERT INTO V_WFCL(TOLLNO,LANENO,DIRECTION,PLATENO," +
					"PLATECOLOR,WFLX,VEHCSPEED,PASSTIME,VEHCCOLOR,VEHCLENGTH,WFTP) " +
					"values(?,?,?,?,?,?,?,?,?,?,?)";
			
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
				System.out.println("[passtime:]"+passtime);
				ps.setDate(8, passtime);
				ps.setString(9, v.getVehicleCorlor());
				ps.setInt(10,0);//number
				ps.setBlob(11,v.getImgBlob().getBinaryStream());//Blob
//				Date ut = CommonUtil.getDateFomate(v.getUpdateTime());
//				ps.setDate(12,ut);//Date
//				
				ps.executeUpdate();
				
//				String sql_select = "select WFTP from V_WFCL t where t.TOLLNO = ? for update";
//				PreparedStatement ps2 = conn.prepareStatement(sql_select);
//				ps2.setString(1, v.getEsId());
//				ResultSet rs = ps2.executeQuery();
//				
//				Blob pc = null;
//			   while (rs.next()) {
//				    pc =  rs.getBlob(1);
//			   }
//			   pc = v.getImgBlob();
//			   
//			   System.out.println("blob-pc"+pc.length());
//			   String sql_update = "update V_WFCL v set WFTP = ? where TOLLNO=? ";
//			   PreparedStatement ps3 = conn.prepareStatement(sql_update);
//			   ps3.setBlob(1, pc.getBinaryStream()); 
//			   ps3.setString(2, v.getEsId());
//			   ps3.executeUpdate();
			     
			   conn.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			

	}
}
