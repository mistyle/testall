package com.example.demo.test.pattern.strategy.examp02;

import java.math.BigDecimal;

/**
 * @program: testall
 * @Date: 2019/5/22 14:38
 * @Author: mistyle
 * @Description:
 */
public class QuoteContext {
	//持有一个具体的报价策略
     private IQuoteStrategy quoteStrategy;

		     //注入报价策略
		      public QuoteContext(IQuoteStrategy quoteStrategy){
		         this.quoteStrategy = quoteStrategy;
		     }

		     //回调具体报价策略的方法
		     public BigDecimal getPrice(BigDecimal originalPrice){
		         return quoteStrategy.getPrice(originalPrice);
		     }
}
