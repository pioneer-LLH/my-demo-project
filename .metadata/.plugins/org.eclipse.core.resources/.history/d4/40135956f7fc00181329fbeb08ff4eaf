package com.comtop.demo.springBootDemo.shili.singletonPattern;
//结合饿汉 懒汉单例模式的优点 的单例模式
public class Singleton {
	private Singleton(){}
	
	private static class HolderClass{
		private final static Singleton instance= new Singleton();
	}
	
	@SuppressWarnings("unused")
	private static Singleton getInstance() {
		return HolderClass.instance;
	}
	
	public static void main(String[] args) {
		Singleton s1,s2;
		s1=Singleton.getInstance();
		s2=Singleton.getInstance();
		System.out.println(s1==s2);
	}
}
