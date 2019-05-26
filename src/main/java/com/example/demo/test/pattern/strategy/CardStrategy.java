package com.example.demo.test.pattern.strategy;

/**
 * @program: testall
 * @Date: 2019/5/22 12:04
 * @Author: mistyle
 * @Description: 充值卡充值
 */
public class CardStrategy implements Strategy{

	@Override
	public Double calRecharge(Double charge, RechargeTypeEnum type) {
		return charge+charge*0.01;
	}

}
