package com.example.demo.test.pattern.strategy.normal;

/**
 * @program: testall
 * @Date: 2019/5/22 14:33
 * @Author: mistyle
 * @Description:
 */
public class StrategyContext {
	//持有一个策略实现的引用
     private IStrategy strategy;
     //使用构造器注入具体的策略类
		      public StrategyContext(IStrategy strategy) {
		         this.strategy = strategy;
		     }

		     public void contextMethod(){
		         //调用策略实现的方法
		         strategy.algorithmMethod();
		     }
}
