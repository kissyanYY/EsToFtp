package com;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.AndFilterBuilder;
import org.elasticsearch.index.query.BoolFilterBuilder;
import org.elasticsearch.index.query.FilterBuilders;
import org.elasticsearch.index.query.FilteredQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortOrder;

import utils.CommonUtil;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EsManager {
	private static String UUIDR = UUID.randomUUID().toString();

	Logger logger = Logger.getLogger(EsManager.class);
	private Client client = EsClient.getClient();

	private String fromTime = "";
	private String endTime = "";
    Date  now ;
    public SearchResponse searchVFList(String startTime,int conf) {
    	now = new Date();
    	endTime = CommonUtil.getTimeString(now)+".000";
    	AndFilterBuilder andf = FilterBuilders.andFilter().cache(true);
    	andf.add(FilterBuilders.rangeFilter("F_PLAY_PHONE_CONF").from(conf).to(100));
    	andf.add(FilterBuilders.rangeFilter("F_START_TIME").from(startTime).to(endTime));
    	
		SearchResponse searchResponse = client.prepareSearch("ezview_2")
				.setTypes("t_prop_vehicle")
				.setSearchType(SearchType.QUERY_THEN_FETCH)
				.setQuery(QueryBuilders.termQuery("F_PLAY_PHONE", 1))
				.setPostFilter(andf)
				.setExplain(false) //explain为true表示根据数据相关度排序，和关键字匹配最高的排在前面
				.setSize(2000)
				.addSort("F_START_TIME", SortOrder.ASC)
			    .addFields("F_SBBH", "F_CDFX", "F_CDBH", "F_START_TIME", "F_HPHM", "F_VEH_TYPE","F_PLATE_COLOR",
			    		"F_VEH_SPEED","F_PIC_PATH1","F_JLBH")
				.get();
		
		return searchResponse;
    }
    
    public SearchResponse searchAQDList(String startTime,int conf) {
    	now = new Date();
    	endTime = CommonUtil.getTimeString(now)+".000";
    	AndFilterBuilder andf = FilterBuilders.andFilter().cache(true); 
    	andf.add(FilterBuilders.rangeFilter("F_SEAT_BELT_CONF").from(conf).to(100));
    	andf.add(FilterBuilders.rangeFilter("F_START_TIME").from(startTime).to(endTime));
    	
		SearchResponse searchResponse = client.prepareSearch("ezview_2")
				.setTypes("t_prop_vehicle")
				.setSearchType(SearchType.QUERY_THEN_FETCH)
				.setQuery(QueryBuilders.termQuery("F_SEAT_BELT_STATUS", 0))
				.setPostFilter(andf)
				.setExplain(false) //explain为true表示根据数据相关度排序，和关键字匹配最高的排在前面
				.setSize(2000)
				.addSort("F_START_TIME", SortOrder.ASC)
			    .addFields("F_SBBH", "F_CDFX", "F_CDBH", "F_START_TIME", "F_HPHM", "F_VEH_TYPE","F_PLATE_COLOR",
			    		"F_VEH_SPEED","F_PIC_PATH1","F_JLBH")
				.get();
		
		return searchResponse;
    }
	

	
}
