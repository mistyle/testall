package com.example.demo.test.pattern.strategy;

/**
 * @program: testall
 * @Date: 2019/5/22 12:03
 * @Author: mistyle
 * @Description: 商户账号充值
 */
public class BusiAcctStrategy implements Strategy {

	@Override
	public Double calRecharge(Double charge, RechargeTypeEnum type) {
		// TODO Auto-generated method stub
		return charge * 0.90;
	}
}
