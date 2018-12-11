package com.comtop.demo.springBootDemo.shili.factoryPattern;

public class Client {
	public static void main(String[] args) {
		Product product;
		product = Factory.getProduct("A");
		product.methodDiff();
		product = Factory.getProduct("B");
		product.methodDiff();
	}
}
