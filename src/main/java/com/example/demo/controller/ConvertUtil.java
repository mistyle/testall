package com.example.demo.controller;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@SuppressWarnings({ "unchecked","rawtypes"})
public class ConvertUtil {
	
	private static ObjectMapper objectMapper= null;
	
	/**
	 * Convert：Json --> JavaBean
	 * @param obj
	 * @param json
	 * @return 
	 * @throws Exception
	 */
	public static final Object toJavaBean(String json,Class cl) throws Exception
	{
		if(null==cl || null==json)
			return null;
		else{
			if(null==objectMapper)
				objectMapper = new ObjectMapper();
			return objectMapper.readValue(json, cl);
		}
	}
	
	
	/**
	 * Convert：JavaBean --> Json
	 * @param obj
	 * @return String
	 * @throws Exception 
	 */
	public static final String toJson(Object obj) throws Exception
	{
		ByteArrayOutputStream bOutStream=new ByteArrayOutputStream();
		
		SimpleModule simpleModule = new SimpleModule();
	    simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
	    simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
	     
		if(null==objectMapper)
			objectMapper= new ObjectMapper();
		 objectMapper.registerModule(simpleModule);
        objectMapper.writeValue(bOutStream, obj);
	        
		return new String(bOutStream.toByteArray(),"UTF-8");
	}
	
	
	/**
	 * Convert：JSON --> List
	 * @param json
	 * @param cl
	 * @return
	 * @throws Exception
	 */
	public static final Object json2List(Object obj,Class cl) throws Exception
	{
		if(null==cl || null==obj)
			return null;
		else{
			if(null==objectMapper)
				objectMapper= new ObjectMapper();
			
			List<Object> list= (List<Object>) obj;
			List<Object> newList=new ArrayList<Object>();

			ByteArrayOutputStream bOutStream=new ByteArrayOutputStream();
			for(int i=0;i<list.size();i++){
				objectMapper.writeValue(bOutStream, list.get(i));
				newList.add(objectMapper.readValue
						(new String(bOutStream.toByteArray(),"UTF-8"), cl));
				bOutStream.reset();
			}
			return newList;
		}
	}
	
	/**
	 * Convert：Object --> JavaBean/List
	 * @param obj
	 * @param cl(javabean/list)
	 * @return (Object/List)
	 * @throws Exception
	 */
	public static final Object obj2JavaBean(Object obj,Class cl) throws Exception
	{
		if(null==cl || null==obj)
			return null;
		else{
			if(null==objectMapper)
				objectMapper= new ObjectMapper();
			return objectMapper.readValue(toJson(obj), cl);
		}
	}
	

	
}
