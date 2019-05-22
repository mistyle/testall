package com.example.demo.test;

import java.util.*;

public class Test {
	


	public static void main(String[] args)   {

		HashMap<String, String> map=new HashMap<String, String>();
		map.put("abd", "123");
		map.put("abd", "456");
		
		for(Map.Entry<String, String> entry: map.entrySet())
		{
			System.out.println("Key: "+ entry.getKey()+ " Value: "+entry.getValue());
		}
		TreeSet<Student> ts = new TreeSet<Student>();

		Student s1 = new Student(23, "xiong");
		Student s2 = new Student(23, "lili");
		Student s3 = new Student(15, "lili");
		Student s4 = new Student(23, "xiong");
		Student s5 = new Student(4, "caicai");

		ts.add(s1);
		ts.add(s2);
		ts.add(s3);
		ts.add(s4);
		ts.add(s5);

		for (Student s : ts) {
			System.out.println(s.getName() + "," + s.getAge());
		}


		List<String> userNames = new ArrayList<String>() {{
			add("Hollis");
			add("hollis");
			add("HollisChuang");
			add("H");
		}};


		System.out.println("使用foreach遍历List");
		for (String userName : userNames) {
			if (userName.equals("Hollis")) {
				userNames.remove(userName);
			}
		}


	}

	


}