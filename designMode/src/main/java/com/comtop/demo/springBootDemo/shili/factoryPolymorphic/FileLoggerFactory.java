package com.comtop.demo.springBootDemo.shili.factoryPolymorphic;
//文件日志记录器工厂类
public class FileLoggerFactory implements LoggerFactory{

	@Override
	public Logger createLogger() {
	
		Logger logger = new FileLogger();
		return logger;
	
	}

}
