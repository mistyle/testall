package com.example.demo.test.pattern.strategy.examp02;

import java.math.BigDecimal;

/**
 * @program: testall
 * @Date: 2019/5/22 14:36
 * @Author: mistyle
 * @Description: //报价策略接口
 */
public interface IQuoteStrategy {
	//获取折后价的价格
    BigDecimal getPrice(BigDecimal originalPrice);
}
