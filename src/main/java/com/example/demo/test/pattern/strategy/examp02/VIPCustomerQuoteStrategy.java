package com.example.demo.test.pattern.strategy.examp02;

import java.math.BigDecimal;

/**
 * @program: testall
 * @Date: 2019/5/22 14:38
 * @Author: mistyle
 * @Description:
 */
public class VIPCustomerQuoteStrategy implements IQuoteStrategy {
	@Override
	public BigDecimal getPrice(BigDecimal originalPrice) {
		System.out.println("恭喜！VIP客户享有8折优惠！");
		originalPrice = originalPrice.multiply(new BigDecimal(0.8)).setScale(2, BigDecimal.ROUND_HALF_UP);
		return originalPrice;
	}
}
