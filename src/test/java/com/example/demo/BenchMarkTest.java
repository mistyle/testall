package com.example.demo;

import com.example.demo.ticket.TicketService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;
//import com.example.demo.ticket.TicketServiceLock;
//import com.example.demo.ticket.TicketServiceLockOne;


// countDownLatch测试
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BenchMarkTest {

	long timed=0l;

	@Autowired
	TicketService ticketService;

//	@Autowired
//	TicketServiceLock ticketServiceLock;
//
//
//	@Autowired
//	TicketServiceLockOne ticketServiceOne;


	private final static  String  ticket_seq="G296";
	private final static    int  THREAD_NUM=2000; //2000

	private CountDownLatch  countDownLatch =new CountDownLatch(THREAD_NUM);

	@Before
	public void start(){

		System.out.println("开始测试");
		timed=System.currentTimeMillis();
	}

	@Test
	public  void benchmark() throws  InterruptedException{
		Thread[]  threads=new Thread[THREAD_NUM];


		for(int i=0;i<THREAD_NUM;i++){
			Thread thread=new Thread(() ->{

				try{
					//System.out.println("sssss");
					//等待countDownLatch为0，所有线程都start后，再运行后续的代码
					countDownLatch.await();
					ticketService.queryTicket(ticket_seq);
				}catch(Exception e){
					e.printStackTrace();
				}
			});
			threads[i]=thread;
			thread.start();

			countDownLatch.countDown();
		} //end for
		//等待上面所有线程执行完毕之后，结束测试
		for(Thread thread:threads) {
			thread.join();
		}

	}


	@After
	public void end(){



		System.out.println("测试时长"+(System.currentTimeMillis()-timed));
	}

}
