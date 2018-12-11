package com.comtop.demo.springBootDemo.shili.factoryAbstract.impl;

import com.comtop.demo.springBootDemo.shili.factoryAbstract.Buttom;
import com.comtop.demo.springBootDemo.shili.factoryAbstract.ComboBox;
import com.comtop.demo.springBootDemo.shili.factoryAbstract.SkinFactory;
import com.comtop.demo.springBootDemo.shili.factoryAbstract.TextField;

//具体工厂  Spring界面皮肤工厂 
public class SpringSkinFactory implements SkinFactory{

	@Override
	public Buttom createButton() {
		return new SpringButton();
	}

	@Override
	public TextField createTextField() {
		return new SpringTextField();
	}

	@Override
	public ComboBox createComboBox() {
		return new SpringComboBox();
	}


	
}
