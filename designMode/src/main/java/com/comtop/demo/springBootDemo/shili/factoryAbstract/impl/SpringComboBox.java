package com.comtop.demo.springBootDemo.shili.factoryAbstract.impl;

import com.comtop.demo.springBootDemo.shili.factoryAbstract.ComboBox;

//具体产品 Spring组合框
public class SpringComboBox implements ComboBox{

	@Override
	public void display() {
		System.out.println("显示Spring蓝色边框组合框");
	}

}
