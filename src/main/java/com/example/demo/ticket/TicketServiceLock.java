//package com.example.demo.ticket;
//
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisPool;
//
//@Component
//public class TicketServiceLock {
//
//	@Autowired
//	private JedisPool jedisPool;
//
//	@Autowired
//	private DatabaseService databaseService;
//
//   Lock  local=new ReentrantLock();
//
//	public Object queryTicket(String ticketSeq){
//		Jedis  jedis=jedisPool.getResource();
//
////		synchronized (jedis) {
////			不能够自己控制进入或退出
////		}
//		local.lock();//获取锁
//
//		try{
//
//		}finally{
//			local.unlock(); //释放锁
//		}
//
//		//1.先从redis中获取余票信息
//		String  value=jedis.get(ticketSeq);
//		if(value!=null){
//			System.out.println("缓存中取得数据"+Thread.currentThread().getName()+" "+value);
//			return  value;
//		}
//		//2.缓存中没有则取数据库
//		value=databaseService.queryFromDatabase(ticketSeq);
//		System.out.println("数据库中取得数据"+Thread.currentThread().getName()+" "+value);
//
//		//3.写入缓存,120秒过期
//		jedis.setex(ticketSeq, 120, value); //防止缓存和数据库长时间不一致
//		jedis.close();
//		return value;
//
//	}
//
//
//
//
//}
