package com.example.demo;//package com.example.demo;
//
//import java.util.Date;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.example.demo.entity.TableIndex;
//import com.example.demo.entity.TableIndexRepository;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class TableIndexTest {
//
//	@Autowired
//	private TableIndexRepository tableIndexRepository;
//	
//	@Before
//	public void before() throws Exception {
//		System.out.println("test  start----------------");
//	}
//
//	@Test
//	public void test() throws Exception {
//		
//		long delStart=System.currentTimeMillis();
//		
//		  ExecutorService executorService = Executors.newCachedThreadPool();
//
//	            Runnable syncRunnable = new Runnable() {
//	                @Override
//	                public void run() {
//	                	 System.out.println(Thread.currentThread().getName());
//	            		for(int j=0;j<500;j++){
//	            			TableIndex  tableIndex=new TableIndex("1112"+j,3+j,j/2==0?1:0,new Date());
//	            			//System.out.println("ssssss"+tableIndexRepository);
//	            			try{
//	            				//tableIndexRepository.save(tableIndex);
//	            				
//	            			}catch(Exception e){
//	            				e.printStackTrace();
//	            			}
//	            			
//	            		}
//	            		
//	            		
//	            		
//	                }
//	            	
//	            };
//	            
//	            executorService.execute(syncRunnable);
//	           
//	           
//		   System.out.println( Thread.currentThread().getName());
//		Thread.sleep(10*1000); //如果这里加上这一句，主线程就不会结束，数据库打开的连接就不会释放,不然就会报错
//		//sleep1秒,39个，10秒 400到500之间
//		long delEnd=System.currentTimeMillis();
//		
//		System.out.println("test end:time"+ (delEnd-delStart)+" ms ------");
//		
//
//	}
//	
//	@After
//	public void end() throws Exception {
//		System.out.println("test end");
//	}
//
//}
