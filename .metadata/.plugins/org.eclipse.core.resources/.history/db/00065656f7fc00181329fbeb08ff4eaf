package com.comtop.demo.springBootDemo.shili.factoryPolymorphic;
//数据库日志记录器工厂类.具体工厂
public class DatabaseLoggerFactory implements LoggerFactory{

	@Override
	public Logger createLogger() {
		//省略连接数据库代码
		Logger logger=new DatabaseLogger();
		return logger;
	}
}
