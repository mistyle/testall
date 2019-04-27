package com.example.demo.test.thread;

/**
 * @program: testall
 * @Date: 2019/4/27 16:44
 * @Author: mistyle
 * @Description:
 */
public class BusinessDemo {

	private boolean  isShowSonThread=true;

	public  synchronized  void  sunBusiness(int i){
		while(!isShowSonThread){
			try{
				this.wait();
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for(int j=1;j<=30;j++){
			System.out.println("子线程运行第"+i+"轮，第"+j+"次");
		}
		isShowSonThread=false;  //打开开关
		this.notify(); //通知主线程

	}

	public  synchronized  void  mainBusiness(int i){
		while(isShowSonThread){  //开关关着，就等待
			try{
				this.wait(); //进入等待阻塞状态
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		for(int j=1;j<=40;j++){
			System.out.println("主线程运行第"+i+"轮，第"+j+"次");
		}
		isShowSonThread=true; //关上开关
		this.notify();

	}

}
