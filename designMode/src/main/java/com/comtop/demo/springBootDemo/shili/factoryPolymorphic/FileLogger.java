package com.comtop.demo.springBootDemo.shili.factoryPolymorphic;
//文件日志记录器:具体产品
public class FileLogger implements Logger{

	@Override
	public void writeLog() {
		System.out.println("文件日志记录器");		
	}

}
