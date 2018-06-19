package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteJDBC {
	public Connection contion = null;
    public  Statement stmt = null;
    
    private static SQLiteJDBC SingelInstance;
	public static SQLiteJDBC getSQLite(){
		SQLiteJDBC sq = new SQLiteJDBC();
		sq.init();
		return sq;
	}
	
	private void init(){
		try {
			Class.forName("org.sqlite.JDBC");
			contion= DriverManager.getConnection("jdbc:sqlite:yy.db");  
			stmt = contion.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static SQLiteJDBC getSingelInstance(){
		if(SingelInstance == null){
				SingelInstance = new SQLiteJDBC();
				SingelInstance.init();
		}
		return SingelInstance;
	}
	
	public void close(){
		try {
			if(stmt != null) stmt.close();
			if(contion!= null) contion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
