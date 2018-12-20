package com.comtop.demo.springBootDemo.shili.singletonPattern;
//饿汉单列模式
public class EagerSingleton {
	private static final EagerSingleton instance = new EagerSingleton();
	private EagerSingleton() {}
	
	public static EagerSingleton getInstance() {
		return instance;
	}
}
