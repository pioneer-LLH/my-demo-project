package com.comtop.demo.springBootDemo.shili.factoryAbstract;

import com.comtop.demo.springBootDemo.shili.factoryAbstract.impl.SpringSkinFactory;

public class test {
	public static void main(String[] args) {
		SkinFactory factory;
		Buttom bt;
		TextField tf;
		ComboBox cb;
		factory = new SpringSkinFactory();
		cb=factory.createComboBox();
		bt=factory.createButton();
		tf=factory.createTextField();
		cb.display();
		bt.display();
		tf.display();
	}
}
