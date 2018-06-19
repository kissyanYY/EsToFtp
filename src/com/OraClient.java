package com;

import java.sql.Connection;
import java.sql.DriverManager;

public class OraClient {
	private static volatile Connection conn = null;
	public static Connection getConnection(){
		
		
//		es= http://172.21.229.85 elasticsearch-czjj 50
		String url = "jdbc:oracle:thin:@172.21.17.6:1521:orcl320";
		String user = "kdwf";
		String password = "kdwfjjzd";
		if (null == conn) {
			synchronized (OraClient.class) {
//				String url = "jdbc:oracle:thin:@10.35.243.203:1521:orcl";
//				String user = "hmdk";
//				String password = "szjjzd_1408";
				try{
					System.out.println("Oracle 链接："+url+",user:"+user+",pwd:"+password);
			        Class.forName("oracle.jdbc.driver.OracleDriver");
			        conn = DriverManager.getConnection(url, user, password);// 获取连接
			    }catch (Exception e){
			        e.printStackTrace();
			    }
			}	
		}
		return conn;
	}
}
