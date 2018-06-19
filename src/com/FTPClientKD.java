package com;

import java.io.IOException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.log4j.Logger;

public class FTPClientKD {
	private static volatile FTPClient client;
	
//	图片的路径是：ftp://46.70.200.32/UNIVIEW/KD-HY/           
//
//		用户名：odin
//
//		密码：szodinpass

	public static FTPClient getClient(){
        if (client == null) {
        		client = getNewClient();
        }
        return client;
	}
	
	public static FTPClient getNewClient(){
		FTPClient client2 = null;
		synchronized (FTPClient.class) {
			client2 = new FTPClient();
			try {
//				client.connect("221.224.36.246",21);
//				client.login("JKF2", "JKF2");
				
				client2.connect("46.70.200.32",21);
				client2.login("odin", "szodinpass");
				client2.setConnectTimeout(5000);
				
				client2.setKeepAlive(true);
				//************此处是重点要不就服务器的图像就被损坏
				client2.setFileType(FTP.BINARY_FILE_TYPE);
				
				//设置上传的路径
//				String pathname = "/hubei/test/";//这个路径就是FTP服务端存储的路径，可以从FileZilla中获取
				String pathname = "/UNIVIEW/KD-HY/";//这个路径就是FTP服务端存储的路径，可以从FileZilla中获取
				client2.changeWorkingDirectory(pathname);
				client2.enterLocalPassiveMode();//每次数据连接之前，ftp client告诉ftp server开通一个端口来传输数
			} catch (IOException e) {
				
				Logger logger = Logger.getLogger(FTPClientKD.class);
				logger.error("【---------FTP连接错误----------】");
				e.printStackTrace();
			}
		}
		return client2;
	}
}
