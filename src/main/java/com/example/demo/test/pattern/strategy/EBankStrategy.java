package com.example.demo.test.pattern.strategy;

/**
 * @program: testall
 * @Date: 2019/5/22 12:02
 * @Author: mistyle
 * @Description: 网银充值
 */
public class EBankStrategy  implements Strategy {
	@Override
	public Double calRecharge(Double charge, RechargeTypeEnum type) {
		return charge*0.85;
	}

}
