package test;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ImageUploadFtp {
	
	   private static void uploadPicture(String urlList) {
	        URL url = null;
	        int imageNumber = 0;

	        try {
	            url = new URL(urlList);
	            DataInputStream dataInputStream = new DataInputStream(url.openStream());

	            String imageName =  "D:/test.jpg";

	            FileOutputStream fileOutputStream = new FileOutputStream(new File(imageName));
	            ByteArrayOutputStream output = new ByteArrayOutputStream();

	            byte[] buffer = new byte[1024];
	            int length;

	            while ((length = dataInputStream.read(buffer)) > 0) {
	                output.write(buffer, 0, length);
	            }
	            byte[] context=output.toByteArray();
	            fileOutputStream.write(output.toByteArray());
	            dataInputStream.close();
	            fileOutputStream.close();
	        } catch (MalformedURLException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

}
