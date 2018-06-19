package test;

import java.io.IOException;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EsDemoTest {

	
	public static void main(String[] args) {
//		String abc  = "{\"F_CDFX\":\"WE\",\"F_SUNVISOR_CONF\":\"0\",\"F_TEMP_PLATE_NUM\":\"-1\",\"F_DAY\":\"0\",\"F_START_TIME_H\":\"17092912\",\"F_PLATE_COLOR\":\"2\",\"F_PLATE_CHARACTOR_CONF_LAST_MIN\":\"99\",\"F_OBJ_ID\":\"0\",\"F_SUNROOF_NUM\":\"0\",\"F_VEH_SIZE\":\"0\",\"F_VEH_COLOR_DEPTH\":\"2\",\"F_SUNVISOR_VICE_DRIVING_CONF\":\"0\",\"F_CDBH\":\"2\",\"F_VEH_LOGO_SUB_BRAND_YEAR\":\"2010款\",\"F_PLAY_PHONE\":\"1\",\"F_SUB_OBJ_ID\":\"0\",\"F_LABEL_SHAPE\":\"0\",\"F_TISSUEBOX_NUM\":\"0\",\"F_END_TIME\":\"2017-09-29 12:33:01.000\",\"F_VEH_SIZE_CONF\":\"100\",\"F_BRIGHTNESS\":\"92.1581\",\"F_PIC_PATH1\":\"http://46.70.200.12:8088/image/vrb2/i2/65a582fe60ae4f61855cfeb98acbbcef/00044?key=2491953&offset=3193324892&high=230268\",\"F_START_TIME\":\"2017-09-29 12:33:01.000\",\"F_SEAT_BELT_STATUS\":\"0\",\"F_START_TIME_M\":\"1709291233\",\"F_START_TIME_L\":\"1506659581000\",\"F_SMOKING\":\"0\",\"F_END_TIME_L\":\"1506659581000\",\"F_PENDANT_NUM\":\"0\",\"F_VEH_SPEED\":\"39\",\"F_END_TIME_H\":\"17092912\",\"F_XZQH\":\"460200\",\"F_TEMP_PLATE_CONF\":\"0\",\"F_VEH_MANUFACTOR\":\"北京汽车\",\"F_HPHM\":\"桂B8S556\",\"F_SMOKING_CONF\":\"0\",\"F_LP_RECT1\":\"{\"x\":644,\"y\":689,\"w\":163,\"h\":45}\",\"F_END_TIME_M\":\"1709291233\",\"F_PLATE_NUM\":\"1\",\"F_JLBH\":\"46020052071002201709291233012063610438\",\"F_TASK_NO\":\"0\",\"F_FRONT_BACK\":\"0\",\"F_VEH_LOGO_BRAND\":\"北京汽车\",\"F_HPYS\":\"2\",\"F_PLAY_PHONE_CONF\":\"15\",\"F_VEH_RECT1\":\"{\"x\":434,\"y\":139,\"w\":628,\"h\":699}\",\"F_SRC_PROP\":\"1\",\"F_HOLD_PHONE\":\"0\",\"F_VIEW_TYPE1\":\"1\",\"F_VEH_COLOR_CONF\":\"100\",\"F_PLATE_NAME\":\"桂B8S556\",\"F_BEST_PIC_INDEX\":\"1\",\"F_VEH_LOGO_BRAND_CONF\":\"99\",\"F_SNAP_NO1\":\"0\",\"F_PLATE_CHARACTOR_CONF_FIRST\":\"99\",\"F_SEATBELT_VICE_DRIVING\":\"1\",\"F_VEH_LOGO_SUB_BRAND\":\"北京40\",\"F_PLATE_CONF\":\"99\",\"F_EXIST_SUNVISOR\":\"-1\",\"F_HOLD_PHONE_CONF\":\"0\",\"F_SUNVISOR_VICE_DRIVING\":\"-1\",\"F_TASK_ID\":\"46020052071002201709291233012063610438\",\"F_VEH_COLOR\":\"4\",\"F_PLATE_CHARACTOR_CONF\":\"99.99,99.76,99.99,99.99,100.00,100.00,100.00\",\"F_SNAP_TIME1\":\"2017-09-29 12:33:01.000\",\"F_PLATE_TYPE\":\"1\",\"F_PLATE_CHARACTOR_NUM\":\"7\",\"F_LABEL_COLOR\":\"0\",\"F_VEH_TYPE\":\"3\",\"F_PLATE_STRUCTURE\":\"0\",\"F_PERSON_NUM\":\"2\",\"F_SEAT_BELT_CONF\":\"53\",\"F_SEATBELT_VICE_DRIVING_CONF\":\"0\",\"F_SBBH\":\"460200520710\",\"F_SUNVISOR_COUNT\":\"-1\",\"F_BEST_PIC_ID\":\"46020052071002201709291233012063610438\",\"F_LABEL_NUM\":\"1\"}";
		String a = "{\"F_SBBH\":\"460200520710\",\"F_CDFX\":\"WE\",\"F_CDBH\":\"2\",\"F_START_TIME\":\"2017-09-29 12:33:01.000\",\"F_HPHM\":\"桂B8S556\",\"F_VEH_TYPE\":\"3\"," +
				"\"F_VEH_SPEED\":\"39\",\"F_PIC_PATH1\":\"http://46.70.200.12:8088/image/vrb2/i2/65a582fe60ae4f61855cfeb98acbbcef/00044?key=2491953&offset=3193324892&high=230268\",\"F_JLBH\":\"46020052071002201709291233012063610438\"}";
		ObjectMapper objectMapper = new ObjectMapper();
			JSONObject jb = JSONObject.parseObject(a);
			String F_SBBH = jb.getString("F_SBBH");
			String F_CDFX = jb.getString("F_CDFX");
			String F_CDBH = jb.getString("F_CDBH");
			String F_START_TIME = jb.getString("F_START_TIME");
			String F_HPHM = jb.getString("F_HPHM");
			String F_VEH_TYPE = jb.getString("F_VEH_TYPE");
			String F_VEH_SPEED = jb.getString("F_VEH_SPEED");
			String F_PIC_PATH1 = jb.getString("F_PIC_PATH1");
			String F_JLBH = jb.getString("F_JLBH");
			
			
//	        Map<String, String> maps = objectMapper.readValue(jb., Map.class);
			
	        System.out.println(F_PIC_PATH1+"maps:"+F_HPHM);
//		EsManager em = new EsManager();
//		Logger logger=Logger.getLogger(EsDemoTest.class);
//		SearchResponse response = em.searchVFList();
//        SearchHits hits = response.getHits(); 
//        long total = hits.getTotalHits(); 
//        SearchHit[] searchHits = hits.hits();
//        System.out.println("总数"+total+",length:"+searchHits.length); 
//        int i=0;
//        for(SearchHit s : searchHits) 
//        {  System.out.println("I;"+i);
//        	i++;
//        	System.out.println("【searchHits length：】"+searchHits.length);
//        	logger.info("ss:"+s.getSourceAsString());
//             
//        }

	}
}
