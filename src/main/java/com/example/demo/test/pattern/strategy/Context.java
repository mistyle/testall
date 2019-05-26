package com.example.demo.test.pattern.strategy;

/**
 * @program: testall
 * @Date: 2019/5/22 14:15
 * @Author: mistyle
 * @Description: 场景类
 */
public class Context {
	private Strategy strategy;

	public Double calRecharge(Double charge, Integer type) {
		strategy = StrategyFactory.getInstance().creator(type);
		return strategy.calRecharge(charge, RechargeTypeEnum.valueOf(type));
	}

	public Strategy getStrategy() {
		return strategy;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}
}
