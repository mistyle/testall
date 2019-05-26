package com.example.demo.test.pattern.strategy.examp02;

import java.math.BigDecimal;

/**
 * @program: testall
 * @Date: 2019/5/22 14:38
 * @Author: mistyle
 * @Description: 外部客户端
 */
public class Client {
	public static void main(String[] args) {
		String type="老用户";

		if("新用户".equals(type)) {
			//1.创建老客户的报价策略
			IQuoteStrategy newQuoteStrategy = new NewCustomerQuoteStrategy();

			//2.创建报价上下文对象，并设置具体的报价策略
			QuoteContext quoteContext = new QuoteContext(newQuoteStrategy);

			//3.调用报价上下文的方法
			BigDecimal price = quoteContext.getPrice(new BigDecimal(100));

			System.out.println("折扣价为：" + price);
		}else if("老用户".equals(type)){
			//1.创建老客户的报价策略
			IQuoteStrategy oldQuoteStrategy = new OldCustomerQuoteStrategy();

			//2.创建报价上下文对象，并设置具体的报价策略
			QuoteContext quoteContext = new QuoteContext(oldQuoteStrategy);

			//3.调用报价上下文的方法
			BigDecimal price = quoteContext.getPrice(new BigDecimal(100));

			System.out.println("折扣价为：" + price);
		}else if("vip".equals(type)){
			//1.创建老客户的报价策略
			IQuoteStrategy oldQuoteStrategy = new OldCustomerQuoteStrategy();

			//2.创建报价上下文对象，并设置具体的报价策略
			QuoteContext quoteContext = new QuoteContext(oldQuoteStrategy);

			//3.调用报价上下文的方法
			BigDecimal price = quoteContext.getPrice(new BigDecimal(100));

			System.out.println("折扣价为：" + price);
		}
     }
}
