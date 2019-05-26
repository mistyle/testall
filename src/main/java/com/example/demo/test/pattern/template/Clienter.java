package com.example.demo.test.pattern.template;

/**
 * @program: testall
 * @Date: 2019/5/22 17:02
 * @Author: mistyle
 * @Description:
 */
public class Clienter {
	public static void main(String[] args){
		HouseTemplate houseOne = new HouseOne("房子1", true);


		       //HouseTemplate houseOne = new HouseOne("房子1");
		        // HouseTemplate houseTwo = new HouseTwo("房子2");
		         houseOne.buildHouse();
		      // houseTwo.buildHouse();
		    }

}
