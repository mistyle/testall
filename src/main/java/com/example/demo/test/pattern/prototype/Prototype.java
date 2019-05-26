package com.example.demo.test.pattern.prototype;

/**
 * @program: testall
 * @Date: 2019/5/22 16:19
 * @Author: mistyle
 * @Description:
 */
public class Prototype  implements Cloneable {
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Prototype(Student student) {
		this.student = student;
	}

	public Object clone() throws CloneNotSupportedException {
		Prototype proto = (Prototype) super.clone();
		return proto;
	}
	private Student student;

}
