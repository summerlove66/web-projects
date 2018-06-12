package com.plan1.utils;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConverter {
	public static String  map2json(Map<String,String>  map) throws JsonProcessingException {
		System.out.println("插入 : " + map);
		ObjectMapper mapper = new ObjectMapper();
		
		String jsonResult =  mapper.writerWithDefaultPrettyPrinter()
				  .writeValueAsString(map);
		return jsonResult;
	}
	public static void main(String[] args) throws JsonProcessingException {
		HashMap<String ,String > mm = new HashMap<String,String>();
		mm.put("sss", "qqqq");
		System.out.println(map2json(mm));
	}
	
}
