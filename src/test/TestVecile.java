package test;

import java.io.DataInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.net.ftp.FTPClient;

import utils.CommonUtil;

import com.FTPClientKD;
import com.Vehicle;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;

public class TestVecile {

	public static void main(String[] args) throws Exception{
		FTPClient ftpClient = FTPClientKD.getClient();
		
		//上传文件,读取本地文件
		String url = "http://photo.163.com/photos/#m=2&aid=27805120&pid=12612354";
		
  	  String databaseUrl = "jdbc:sqlite:yy.db";
  	  ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);
  	  Dao<Vehicle,String> accountDao =
                DaoManager.createDao(connectionSource, Vehicle.class);
		DatabaseConnection dc = connectionSource.getReadWriteConnection("vehicle");
  	  accountDao.setAutoCommit(dc, false);
  	  List<Vehicle> lp = new ArrayList<>();
  	  System.out.println("A:"+new Date());
		for (int i=0;i<=2000;i++){
			URL purl = new URL(url+i);
			Vehicle p = new Vehicle();
			p.setIllegalType("1223");
			p.setIllegalPlace("11109"+i);
			p.setIllegalDate(CommonUtil.getTimeString(null));
			p.setImgIndex(""+i);
			p.setImgUrl(url+i);
			p.setDirection("02");
			p.setDirLine("01");
			p.setEsId(UUID.randomUUID().toString());
			p.setMaxSpeed("120");
			p.setSpeed("80");
			p.setPlate(CommonUtil.getRandomPlat());
			p.setVehicleType("1");
			p.setPname(p.getPname());
			
			DataInputStream dataInputStream = new DataInputStream(purl.openStream());
			ftpClient.storeFile(p.getPname(), dataInputStream);
			
			System.out.println("wanc:"+p.getPname());
			lp.add(p);
		}
		accountDao.create(lp);
	  	  System.out.println("B:"+new Date());
		accountDao.commit(dc);
		connectionSource.close();
		ftpClient.logout();
	}
}
