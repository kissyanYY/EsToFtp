package test;

import com.DaoService;

public class TestUpdateTime {

	public static void main(String[] args) {
		String updateTime ="2010-10-18 10:48:24";
		DaoService service= new DaoService();
		
		service.upSyncTime(updateTime,"1223");
		service.upSyncTime(updateTime,"6011");
		
		updateTime = service.getUpdateTime("1223");
		System.out.println("updateTime"+updateTime);
		
		updateTime = service.getUpdateTime("6011");
		System.out.println("updateTime"+updateTime);
		
		int i = service.getConfByTpye("1223");
		System.out.println("i:"+i);
	}
}
