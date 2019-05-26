package com.example.demo.test.thread.wait_notify2;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: testall
 * @Date: 2019/5/23 17:29
 * @Author: mistyle
 * @Description:
 */
public class Buffer {

	private static final int MAX_CAPACITY = 1;
	private List innerList = new ArrayList<>(MAX_CAPACITY);

	void add() {
		if (isFull()) {
			throw new IndexOutOfBoundsException();
		} else {
			innerList.add(new Object());
		}
		System.out.println(Thread.currentThread().getName() + " add");

	}

	void remove() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException();
		} else {
			innerList.remove(MAX_CAPACITY - 1);
		}
		System.out.println(Thread.currentThread().getName() + " remove");
	}

	boolean isEmpty() {
		return innerList.isEmpty();
	}

	boolean isFull() {
		return innerList.size() == MAX_CAPACITY;
	}
}


