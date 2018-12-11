package com.comtop.demo.springBootDemo.shili.factoryAbstract.impl;

import com.comtop.demo.springBootDemo.shili.factoryAbstract.Buttom;

//具体产品,Summer按钮
public class SummerButton implements Buttom{
	@Override
	public void display() {
		System.out.println("显示Summer浅蓝色按钮");
	}
}
