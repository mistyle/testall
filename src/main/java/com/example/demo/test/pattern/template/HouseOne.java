package com.example.demo.test.pattern.template;

/**
 * @program: testall
 * @Date: 2019/5/22 17:01
 * @Author: mistyle
 * @Description:
 */
public class HouseOne  extends HouseTemplate {



	 HouseOne(String name) {
		super(name);  //调用父类的构造方法，给name属性赋值 ,后面的buildDoor就能拿到这个name
		System.out.println("111"+name);

	}
	HouseOne(String name, boolean isBuildToilet){
		super(name,isBuildToilet);  //调用上面那个方法
		         //this.isBuildToilet = isBuildToilet;
		System.out.println("2"+isBuildToilet);
		    }
	public boolean isBuildToilet;


	@Override
	protected void buildDoor() {
		System.out.println(name + "的门要采用防盗门");
	}

	@Override
	protected void buildWindow() {
		System.out.println(name + "的窗户要面向北方");
	}

	@Override
	protected void buildWall() {
		System.out.println(name + "的墙使用大理石建造");
	}

	@Override
	protected void buildBase() {
		System.out.println(name + "的地基使用钢铁地基");
	}

	@Override
    protected void buildToilet() {
		         System.out.println(name + "的厕所建在东南角");
		     }
}