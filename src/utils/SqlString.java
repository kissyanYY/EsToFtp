package utils;


public  class SqlString {
	public static String create_updateTable = 
			"CREATE TABLE  updateTime(GXSJ_1223 VARCHAR(32),GXSJ_1240 VARCHAR(32),CONF_1223 VARCHAR(4),CONF_1240 VARCHAR(4));" +
			"insert into updateTime(GXSJ_1223,GXSJ_1240,CONF_1223,CONF_1240) values('#SYSDATE#','#SYSDATE#','90','90');";

	public static String Select_update = 
			"select * from updateTime;";
	
	public static String Update_updateTime= 
			"update updateTime set GXSJ_#TYPE#='#GXSJ#';";
	
	public static String update_time = 
			"CREATE TABLE  updateTime(GXSJ VARCHAR(32));";
	
	public static String CREATE_TABLE =
			"CREATE TABLE vehicle("+
		    		  "illegalType VARCHAR(10),"+
		    		  "illegalPlace VARCHAR(32),"+
		    		  "direction VARCHAR(8),"+
		    		  "dirLine VARCHAR(4),"+
		    		  "illegalDate VARCHAR(32),"+
		    		  "plate VARCHAR(10),"+
		    		  "vehicleType VARCHAR(10),"+
		    		  "speed VARCHAR(10),"+
		    		  "maxSpeed VARCHAR(10),"+
		    		  "imgIndex VARCHAR(20),"+
		    		  "updateTime VARCHAR(32),"+
		    		  "imgUrl VARCHAR(32),"+
		    		  "esId VARCHAR(32)," +
		    		  "pname VARCHAR(64)" +
		    		  ");";
	
	
	public static String SELECT_COUNT= 
			"select count(*) as countNum from vehicle;"; 
	
	public static String SELECT_Table = 
			"SELECT tbl_name FROM sqlite_master WHERE type = 'table';";
	
}
