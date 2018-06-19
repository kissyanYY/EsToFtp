package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtil {
	static DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	static DateFormat df2 = new SimpleDateFormat("yyyyMMddHHmmss");
	
    public static Boolean isNotEmpty(Object obj) {
        if (null != obj && !"".equals(obj) && !"null".equals(obj)) {
            return true;
        }
        return false;
    }
    
    public static java.sql.Date getDateFomate(String dd){
    	java.sql.Date dy = null;
    	try {
    		dy= new java.sql.Date(df.parse(dd).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return dy;
    }
    
    public static String getTimeStringCommon(String dy){
    	if(dy != null && !"".equals(dy)){
    		try {
    			Date tim = df.parse(dy);
    			return df.format(tim);
    		} catch (ParseException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	}
		return "";
    }
    
    public static String getTimeStringPic(String dy){
    	if(dy != null && !"".equals(dy)){
    		try {
    			Date tim = df.parse(dy);
    			return df2.format(tim);
    		} catch (ParseException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	}
		return "";
    }
    
    public static String getTimeString(Date tim){
    	if(tim == null) tim = new Date();
    	return df.format(tim);
    }
    
	public static String getUUID12(){
		String s= UUID.randomUUID().toString();
		s = s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24);
		return s;
	}
	
	public static String getRandomPlat(){
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
		int chepai = (int)((Math.random()*9+1)*10000);
		return  ""+chars.charAt((int)(Math.random()*26)) + chepai;
	}
	
	public static String replaceTSZF(String str){
		String regEx="[`~!%^&*()+=|{}';',\\[\\]<>/?~！@#￥%……&*（）——+|{}【】‘；”“’。，、？]"; 
		Pattern p = Pattern.compile(regEx); 
		Matcher m = p.matcher(str);
		return m.replaceAll("").trim();
	} 
	
	public static boolean isWfSd(String bt){
//		bt  = "2018-02-23 18:00:00.000";
		String b = bt.substring(11, 16);
		b = b.replace(":", "");
		int stime = Integer.parseInt(b);
		if( (1630 < stime && stime < 1830) || 
			(700 < stime && stime < 900)	){
			return true;
		}
		return false;
	}
}
