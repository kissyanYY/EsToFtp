package service;

import org.apache.log4j.Logger;

public class ServiceThread extends Thread{
	private Logger logger=Logger.getLogger(ServiceThread.class);
	public String illeglType = "";
	
	@Override
	public void run() {
	    SyncService service= new SyncService(illeglType);
	    logger.info("【线程启动】"+illeglType);
		while(true){
			try{
				int nullCount = service.startService();
				if(nullCount > 200){
					service.nullDateCount = 0;
					logger.info("【无数据，休眠一分钟】"+illeglType);
					sleep(60*1000);//休眠一分钟
				}
			}
			catch (Exception e) {
				service.nullDateCount = 0;
				logger.info(illeglType+"【E----------------程序异常，休眠1小时继续】"+e.getMessage());
				try {
					sleep(60*60*1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}//休眠一小时
			}
		}
	}
}
