package test;

import java.io.DataInputStream;
import java.net.URL;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import com.FTPClientKD;

//import org.apache.commons.net.ftp.FTP;
//import org.apache.commons.net.ftp.FTPClient;
//import org.junit.Test;

//测试FTP的类
public class FtpTest {
	
	public static void main(String[] args)  throws Exception{
		
        String urlS = "https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1508211082&di=b657075539d8fe2bd3e641921fc53637&src=http://file1.gtuu.com/adaptshowimg/20140701/20140701114634_67824408.jpg";
        URL url = new URL(urlS);
		//创建一个FTPClient对象
		FTPClient ftpClient = FTPClientKD.getClient();
		
		//上传文件,读取本地文件
		DataInputStream dataInputStream = new DataInputStream(url.openStream());
//		FileInputStream inputStream = new FileInputStream(new File(path));
		
		
		//设置上传的路径
		String pathname = "/hubei/test/";//这个路径就是FTP服务端存储的路径，可以从FileZilla中获取
		ftpClient.changeWorkingDirectory(pathname);
		
		//参数一：服务器端文档名；参数二：上传文档的inputStream
		String remote = "test.jpg";
		ftpClient.storeFile(remote, dataInputStream);
		
		//关闭连接
		ftpClient.logout();
		
	}
}
