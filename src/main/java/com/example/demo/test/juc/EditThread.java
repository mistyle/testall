package com.example.demo.test.juc;

import java.util.Map;

class EditThread  implements Runnable{
	
	Map<Integer, Integer> hashMap;
	int i;
	 
    public EditThread(Map<Integer, Integer> hashMap,int i) {
        this.hashMap = hashMap;
        this.i = i;
    }
 
    @Override
    public void run() {
        //hashMap.put(0, hashMap.get(0) + 1);
        hashMap.put(0,  i);
    }



}
