package com.example.demo.test;

public class InvokeTest {
	
	int  a=0;
	public static void main(String[] args) {
		InvokeTest  test=new  InvokeTest();
		test.change(test);
		System.out.println(test.a);  //对象里面的值发生了变化
		
		int b=0;
		test.change(b);
		System.out.println(b);  //基本类型的值没有变化
		
		String s="123";
		System.out.println(s);  //String与基本类型一样，也没有变化，String 是final类型，不能被继承
		
		
	}
	
	public  void  change(InvokeTest invoke){
		invoke.a=2;
	}
	
	public  void  change(int  a){
		a=2;
	}
	public  void  change(String  a){
		a="321";
	}

}
