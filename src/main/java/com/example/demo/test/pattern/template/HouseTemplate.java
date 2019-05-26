package com.example.demo.test.pattern.template;

/**
 * @program: testall
 * @Date: 2019/5/22 17:00
 * @Author: mistyle
 * @Description:
 */
public abstract class HouseTemplate {

	public boolean isBuildToilet;


	public HouseTemplate(String name) {
		System.out.println("sssssss"+name);
		this.name = name;

	}

	public HouseTemplate(String name,boolean isBuildToilet ) {
		System.out.println("sssssss"+name);
		this.name = name;
		this.isBuildToilet = isBuildToilet;
	}

	protected String name;

	protected abstract void buildDoor();

	protected abstract void buildWindow();

	protected abstract void buildWall();

	protected abstract void buildBase();
	protected abstract void buildToilet();

	//钩子方法
	public boolean isBuildToilet(){
		       return isBuildToilet;
		     }

	//公共逻辑
	public final void buildHouse() {

		buildBase();
		buildWall();
		buildDoor();
		buildWindow();
		System.out.println(isBuildToilet());
		if(isBuildToilet()){
			            buildToilet();
			        }

	}

}