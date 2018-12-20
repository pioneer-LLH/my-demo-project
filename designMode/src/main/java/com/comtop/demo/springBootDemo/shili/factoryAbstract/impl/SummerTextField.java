package com.comtop.demo.springBootDemo.shili.factoryAbstract.impl;

import com.comtop.demo.springBootDemo.shili.factoryAbstract.TextField;

//文本框具体产品  Summer文本框
public class SummerTextField implements TextField{

	@Override
	public void display() {
System.out.println("显示Summer绿色文本框");		
	}
	
}
