package utils;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.log4j.Logger;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64Img {
   static Logger log = Logger.getLogger(Base64Img.class);
	/** 
	 * 远程读取image转换为Base64字符串 
	 * @param imgUrl 
	 * @return 
	 */  
	public static String Image2Base64(String imgUrl) throws Exception {  
		
	    URL url = null;  
	    InputStream is = null;   
	    ByteArrayOutputStream outStream = null;  
	    HttpURLConnection httpUrl = null;  
	    try{  
	        url = new URL(imgUrl);  
	        httpUrl = (HttpURLConnection) url.openConnection();  
	        httpUrl.connect();  
	        httpUrl.getInputStream();  
	        is = httpUrl.getInputStream();            
	          
	        outStream = new ByteArrayOutputStream();  
	        //创建一个Buffer字符串  
	        byte[] buffer = new byte[1024];  
	        //每次读取的字符串长度，如果为-1，代表全部读取完毕  
	        int len = 0;  
	        //使用一个输入流从buffer里把数据读取出来  
	        while( (len=is.read(buffer)) != -1 ){  
	            //用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度  
	            outStream.write(buffer, 0, len);  
	        }  
	        // 对字节数组Base64编码  
	        return new BASE64Encoder().encode(outStream.toByteArray());  
	    }catch (Exception e) { 
	    	imgUrl = "";
	    	log.error(":图片转换64错误"+e.getMessage());
//	        e.printStackTrace();    
	    }  
	    finally{  
	        if(is != null)  
	        {  
	            try {  
	                is.close();  
	            } catch (IOException e) {  
	                e.printStackTrace();  
	            }  
	        }  
	        if(outStream != null)  
	        {  
	            try {  
	                outStream.close();  
	            } catch (IOException e) {  
	                e.printStackTrace();  
	            }  
	        }  
	        if(httpUrl != null)  
	        {  
	            httpUrl.disconnect();  
	        }  
	    }  
	    return imgUrl;  
	}  
	
	public static String GetImageStrFromPath(String imgPath) {
		InputStream in = null;
		byte[] data = null;
		// 读取图片字节数组
		try {
			in = new FileInputStream(imgPath);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 对字节数组Base64编码
		BASE64Encoder encoder = new BASE64Encoder();
		// 返回Base64编码过的字节数组字符串
		return encoder.encode(data);
	}

	/**
	 * @Title: GenerateImage
	 * @Description: TODO(base64字符串转化成图片)
	 * @param imgStr
	 * @return
	 */
	public static boolean GenerateImage(String imgStr) {
		if (imgStr == null) // 图像数据为空
			return false;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64解码
			byte[] b = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}
			// 生成jpeg图片
			String imgFilePath = "d://222.jpg";
			OutputStream out = new FileOutputStream(imgFilePath);
			out.write(b);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
//		String a = getImageStr("D://11.jpg");
////		String a = getImageStr("D://00020.jpg");
//		String b  = Image2Base64("https://avatar.csdn.net/1/5/D/1_tiancaolin.jpg?1526540785");
//		System.out.println(""+a);
//		System.out.println("---------------------------");
//		System.out.println(""+b);
//		generateImage(a,"D://1100.jpg");
//		generateImage(b,"D://1101.jpg");
////		Base64Img.GenerateImage(a);
	}
	
	/**
	 * @Description: 根据图片地址转换为base64编码字符串
	 * @Author: 
	 * @CreateTime: 
	 * @return
	 */
	public static String getImageStr(String imgFile) {
	    InputStream inputStream = null;
	    byte[] data = null;
	    try {
	        inputStream = new FileInputStream(imgFile);
	        data = new byte[inputStream.available()];
	        inputStream.read(data);
	        inputStream.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    // 加密
	    BASE64Encoder encoder = new BASE64Encoder();
	    return encoder.encode(data);
	}
	
	/**
	 * @Description: 将base64编码字符串转换为图片
	 * @Author: 
	 * @CreateTime: 
	 * @param imgStr base64编码字符串
	 * @param path 图片路径-具体到文件
	 * @return
	*/
	public static boolean generateImage(String imgStr, String path) {
	if (imgStr == null)
		return false;
	BASE64Decoder decoder = new BASE64Decoder();
	try {
		// 解密
		byte[] b = decoder.decodeBuffer(imgStr);
		// 处理数据
		for (int i = 0; i < b.length; ++i) {
			if (b[i] < 0) {
				b[i] += 256;
			}
		}
		OutputStream out = new FileOutputStream(path);
		out.write(b);
		out.flush();
		out.close();
		return true;
		} catch (Exception e) {
			return false;
	}
	}
}

