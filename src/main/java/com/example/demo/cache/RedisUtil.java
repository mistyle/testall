package com.example.demo.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.controller.ConvertUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


@Component
public class RedisUtil  {


	@Autowired
	private JedisPool jedisPool;



	public void put(String key, Object obj) {	

		Jedis jedis =jedisPool.getResource();
		try{
			if(null!=jedis){
				jedis.set(key, ConvertUtil.toJson(obj));
			}
		}catch(Exception e){
			jedisPool.returnBrokenResource(jedis);  
		}finally{
			close(jedisPool, jedis);
		}
	}
	public void put(String cacheName, String key, Object obj){	
		Jedis jedis =jedisPool.getResource();
		try{
			if(null!=jedis){
				jedis.hset(cacheName, key, ConvertUtil.toJson(obj));
			}
		}catch(Exception e){
			 jedisPool.returnBrokenResource(jedis);  
		}finally{
			close(jedisPool, jedis);
		}
	}

	public Object get(String cachName,String key) {
		Jedis jedis =jedisPool.getResource();
		try{
			if(null==jedis)return null;
			
			Object obj= ConvertUtil.toJavaBean(jedis.hget(cachName, key), Object.class);
			return obj;
		}catch(Exception e){
			 jedisPool.returnBrokenResource(jedis);  
		}finally{
			close(jedisPool, jedis);
		}
		return null;
	}
	
	public Map<String,String> getAll(String cachName){
		Jedis jedis =jedisPool.getResource();
		try{
			if(null==jedis)return null;
			
			Map<String,String> taskMap = new ConcurrentHashMap<String,String>();
			taskMap=jedis.hgetAll(cachName);
			
			return taskMap;
		}catch(Exception e){
			 jedisPool.returnBrokenResource(jedis);  
		}finally{
			close(jedisPool, jedis);
		}
		return null;
	}
	public Long removeFile(String key){
		Jedis jedis =jedisPool.getResource();
		try{
			if(null==jedis) return 0l;
			if("".equals(key)||null==key)return 0l;
			
			return jedis.del(key);
		}catch(Exception e){
			 jedisPool.returnBrokenResource(jedis);  
		}finally{
			close(jedisPool, jedis);
		}	
		 return null;
	}
	
	public Long removeFile(String redisCache,String taskId ){
		Jedis jedis =jedisPool.getResource();
		try{
			if(null==jedis) return 0l;
			
			return jedis.hdel(redisCache,taskId);
		}catch(Exception e){
			 jedisPool.returnBrokenResource(jedis);  
		}finally{
			close(jedisPool, jedis);
		}
		 return null;
	}

	
	public  void close(JedisPool jedisPool,Jedis jedis) {  
        try {  
            jedisPool.returnResource(jedis);
   
        } catch (Exception e) {  
            if (jedis.isConnected()) {  
                jedis.quit();  
                jedis.disconnect();  
            }  
        }  
    }
}
