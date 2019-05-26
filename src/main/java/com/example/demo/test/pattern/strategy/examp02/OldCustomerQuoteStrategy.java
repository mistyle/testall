package com.example.demo.test.pattern.strategy.examp02;

import java.math.BigDecimal;

/**
 * @program: testall
 * @Date: 2019/5/22 14:37
 * @Author: mistyle
 * @Description:
 */
public class OldCustomerQuoteStrategy implements IQuoteStrategy {

	@Override
	public BigDecimal getPrice(BigDecimal originalPrice) {
		System.out.println("恭喜！老客户享有9折优惠！");
		 originalPrice = originalPrice.multiply(new BigDecimal(0.9)).setScale(2, BigDecimal.ROUND_HALF_UP);
		 return originalPrice;

	}
}
