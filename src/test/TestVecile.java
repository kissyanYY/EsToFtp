package test;

import java.io.IOException;
import java.net.URL;
import java.sql.Blob;

import org.hibernate.Hibernate;

public class TestVecile {

	public static void main(String[] args) throws Exception{
		//上传文件,读取本地文件
		String url = "http://img3.ph.126.net/hYhUsNbJm56-y-RbTS_J1g==/1670553986777895843.jpg";
		Blob b = getBlobFfomUrl(url);
		
		System.out.println(""+b.length());
	}
	
	
	public static Blob getBlobFfomUrl(String ur) throws IOException{
		URL url = new URL(ur);
		Blob img = Hibernate.createBlob(url.openStream());
		return img;
	}
}
