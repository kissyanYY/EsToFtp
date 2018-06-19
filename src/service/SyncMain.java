package service;

import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.SQLiteJDBC;

import utils.CommonUtil;
import utils.SqlString;

public class SyncMain extends Thread{
	Logger logger = Logger.getLogger(SyncMain.class);	
	public static void main(String[] args) {
		SyncMain sync = new SyncMain();
		
		if(args != null && args.length >0){
			String instr1 = args[0];
			if(CommonUtil.isNotEmpty(instr1)){
				try{
					int vi = Integer.parseInt(instr1);
//					GlobleVehicleList.periodTime = vi;
					System.out.println("【参数为】"+ vi);
				}catch (Exception e) {
					System.out.println("【参数错误】"+e.getMessage());
				}
			}
		}
		sync.startService();
	}

	/**
	 * 开始程序，并且同步本地库
	 * @param args
	 */
	public void startService(){
	    Statement stmt = null;
	    
	  
	    boolean isCreat = true;
	    try {
	      System.out.println("【程序启动】");
    	  
	      SQLiteJDBC dao  =  SQLiteJDBC.getSQLite();
	      stmt = dao.stmt;

	      String sql = SqlString.SELECT_Table;
	      ResultSet rs = stmt.executeQuery(sql);
	  	  StringBuffer tbl_name  =new StringBuffer();
	      while ( rs.next() ) {
	    	  String tbe	= rs.getString("tbl_name");
	    	  tbl_name.append(tbe);
	       }
	      
	      if(tbl_name.toString().contains("vehicle")){
	    	  System.out.println("*****sysout ***违法图片同步服务开始********");
	    	  logger.info("*******info *违法图片同步服务开始********");
	    	  isCreat = false;
	    	  startSyncService();
	      }
	      else{
	    	  logger.info("********初始化创建表*******");

		      //创建表
		      if(!tbl_name.toString().contains("updateTime")){
		    	  String createIn=  SqlString.create_updateTable;
		    	  createIn = createIn.replace("#SYSDATE#", "2018-03-06 00:00:00.000");
		    	  stmt.executeUpdate(createIn); 
		      }
    		  
	    	 stmt.executeUpdate(SqlString.CREATE_TABLE);
	     	 logger.info("建表成功");
	     	 
	     	startSyncService();
	     	  //插入 远程数据 
	     	 isCreat = true;
//	     	 	getRemoDatas(dao);
	      }
	       rs.close();
	       dao.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	    }
	    
	    System.out.println("Opened database successfully");
//	    if(isCreat)System.exit(0);
	}
	
	private void startSyncService() throws Exception{
		System.out.println("---1---开启服务");
		ServiceThread st1 = new ServiceThread();
		st1.illeglType = "1223";
		st1.start();

		ServiceThread st2 = new ServiceThread();
		st2.illeglType = "6011";
		st2.start();
		
		ServiceThread st3 = new ServiceThread();
		st3.illeglType = "0000";
		st3.start();

		ServiceThread st4 = new ServiceThread();
		st4.illeglType = "1111";
		st4.start();
	}
	
	
}
