package com.example.demo.test.pattern.staticfactory;

/**
 * @program: testall
 * @Date: 2019/5/22 11:21
 * @Author: mistyle
 * @Description:
 */
public class ProductFactory {
	public static IProduct product=null;//静态
	public static IProduct product1=null;//静态

	public static void main(String[] args)  throws Exception {
		IProduct  product=	getProduct("ProductA");
	}

	//静态方法
	public static IProduct getProduct(String productType) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
//   if(productType==null||productType.trim().equals("")){//默认创建ProductA
//     product=new ProductA();
//   }else if(productType.trim().equals("ProductA")){
//     product=new ProductA();
//   }else if(productType.trim().equals("ProductB")){
//     product=new ProductB();
//   }
		//静态工厂一般使用类的反射来构建对象，像上面的构建也可以。
		if(productType.trim().equals("ProductA")){
			product=(IProduct)Class.forName("com.example.demo.test.pattern.staticfactory.ProductA").newInstance();
			System.out.println("ddd"+product);
			product1=(IProduct)Class.forName("com.example.demo.test.pattern.staticfactory.ProductA").newInstance();
			System.out.println("222"+product1);
		}else if(productType.trim().equals("ProductB")){
			product=(IProduct)Class.forName("com.example.demo.test.pattern.staticfactory.ProductB").newInstance();
		}
		return product;
	}
}
/**
 * 静态工厂的优点:
 * (1) 有名称，构造方法没有可自定义的名称
 * (2)不必在每次调用的时候，都创建一个新的对象
 */
