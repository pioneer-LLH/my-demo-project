package com.comtop.demo.springBootDemo.shili.factoryPattern;

public class Factory {
	//静态工厂方法
	public static Product getProduct(String arg) {
		Product product = null;
		if(arg.equalsIgnoreCase("A")) {
			product = new ConcreteProductA();
		}else if(arg.equalsIgnoreCase("B")) {
			product = new ConcreteProductB();
		}
		return product;
	}
}
