package com.example.demo.test.parametertype;

/**
 * @program: testall
 * @Date: 2019/5/14 13:10
 * @Author: mistyle
 * @Description:
 */
public class FruitGenerator<T> implements Generator<T>{
	@Override
	public T next() {
		return null;
	}
}
/**
 * 不写成FruitGenerator<T>,编译报错 FruitGenerator
 */
