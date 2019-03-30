//package com.example.demo.ticket;
//
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisPool;
//
//@Component
//public class TicketServiceLockOne {
//
//	@Autowired
//	private JedisPool jedisPool;
//
//	@Autowired
//	private DatabaseService databaseService;
//
//	Map<String,String> mapLock  =new ConcurrentHashMap<String,String>();
//
//	public Object queryTicket(String ticketSeq){
//		Jedis  jedis=jedisPool.getResource();
//
//
//
//		//1.先从redis中获取余票信息
//		String  value=jedis.get(ticketSeq);
//		if(value!=null){
//			System.out.println("缓存中取得数据"+Thread.currentThread().getName()+" "+value);
//			return  value;
//		}
//
//		boolean  lock=false;
//		try{
//			//String  put= mapLock.put(ticketSeq, "true");
//			lock= mapLock.putIfAbsent(ticketSeq, "true")==null?true:false;
//			if(lock){
//				//再次查询缓存
//				value=jedis.get(ticketSeq);
//				if(value!=null){
//					System.out.println("缓存中取得数据"+Thread.currentThread().getName()+" "+value);
//					return  value;
//				}
//
//				//2.缓存中没有则取数据库
//				value=databaseService.queryFromDatabase(ticketSeq);
//				System.out.println("数据库中取得数据"+Thread.currentThread().getName()+" "+value);
//
//				//3.写入缓存,120秒过期
//				jedis.setex(ticketSeq, 120, value); //防止缓存和数据库长时间不一致
//
//			}
//			else{
//				value="0";
//			}
//		}finally{
//			jedis.close();
//		}
//		return value;
//
//	}
//
//
//
//
//}
