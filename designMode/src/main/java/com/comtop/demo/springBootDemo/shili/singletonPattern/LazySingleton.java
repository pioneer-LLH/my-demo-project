package com.comtop.demo.springBootDemo.shili.singletonPattern;
//懒汉单例模式
public class LazySingleton {
	private volatile static LazySingleton instance = null;
	private LazySingleton() {}
	
	public static LazySingleton getinstance() {
		if(instance == null) {
			synchronized (LazySingleton.class) {
				if(instance == null) {
					instance =new LazySingleton();
				}
			}
		}
		return instance;
	}
}
