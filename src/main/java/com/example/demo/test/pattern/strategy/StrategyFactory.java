package com.example.demo.test.pattern.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: testall
 * @Date: 2019/5/22 14:16
 * @Author: mistyle
 * @Description:
 */
public class StrategyFactory {
	private static StrategyFactory factory = new StrategyFactory();
	private StrategyFactory(){
	}
	private static Map<Integer ,Strategy> strategyMap = new HashMap<>();
	static{
		strategyMap.put(RechargeTypeEnum.E_BANK.value(), new EBankStrategy());
		strategyMap.put(RechargeTypeEnum.BUSI_ACCOUNTS.value(), new BusiAcctStrategy());
		strategyMap.put(RechargeTypeEnum.MOBILE.value(), new MobileStrategy());
		strategyMap.put(RechargeTypeEnum.CARD_RECHARGE.value(), new CardStrategy());
	}
	public Strategy creator(Integer type){
		return strategyMap.get(type);
	}
	public static StrategyFactory getInstance(){
		return factory;
	}
}
