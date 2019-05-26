package com.example.demo.test.pattern.strategy.examp02;

import java.math.BigDecimal;

/**
 * @program: testall
 * @Date: 2019/5/22 14:36
 * @Author: mistyle
 * @Description: //新客户的报价策略实现类
 */
public class NewCustomerQuoteStrategy implements IQuoteStrategy {
	@Override
	public BigDecimal getPrice(BigDecimal originalPrice) {
		System.out.println("抱歉！新客户没有折扣！");
		return originalPrice;
	}
}