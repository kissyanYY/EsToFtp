package com;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import utils.SqlString;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;

public class DaoService {
	
//	private String databaseUrl = "jdbc:oracle:thin:@172.21.229.50:1521:orcl";
	private String databaseUrl = "jdbc:sqlite:yy.db";

	private ConnectionSource connectionSource;
	private DatabaseConnection dc ;
	private Dao<Vehicle,String> accountDao ;
	private SQLiteJDBC dao  =  SQLiteJDBC.getSQLite();
	private Statement stmt ;
	private Logger logger=Logger.getLogger(DaoService.class);

	
	public DaoService(){
		try {
			connectionSource = new JdbcConnectionSource(databaseUrl);
			accountDao =
					DaoManager.createDao(connectionSource, Vehicle.class);
			dc = connectionSource.getReadWriteConnection("vehicle");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void saveRecordToSQL(Vehicle v){
		try {
			accountDao.create(v);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public String getUpdateTime(String type){
		stmt = dao.stmt;
		String updateTime = "";
		String gxsj_type = "GXSJ_"+type;
		String sql = SqlString.Select_update;
	    try{
			 ResultSet rs = stmt.executeQuery(sql);
		     while ( rs.next() ) {
		    	  updateTime	= rs.getString(gxsj_type);
		     }
	       } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
         }
	    return updateTime;
	}
	
	
	public int getConfByTpye(String type){
		stmt = dao.stmt;
		int conf = 100;
		String gxsj_type = "CONF_"+type;
		String sql = SqlString.Select_update;
	    try{
			 ResultSet rs = stmt.executeQuery(sql);
		     while ( rs.next() ) {
		    	 conf	= rs.getInt(gxsj_type);
		     }
	       } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
         }
	    return conf;
	}
	
	
	public void upSyncTime(String updateString,String illegal_type){
		stmt = dao.stmt;
		
		String sql = SqlString.Update_updateTime;
		sql=sql.replace("#GXSJ#", updateString);
		sql=sql.replace("#TYPE#", illegal_type);
		
	    try{
			 int result = stmt.executeUpdate(sql);
	       } catch (SQLException e) {
			// TODO Auto-generated catch block
	    	   logger.error("【严重错误---更新时间错误】"+e.getMessage());
			e.printStackTrace();
         }
	}

}
