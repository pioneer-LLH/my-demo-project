package com.comtop.demo.springBootDemo.shili.factoryPolymorphic;

public class Client {
	public static void main(String[] args) {
		LoggerFactory factory;
		Logger logger;
		factory = new DatabaseLoggerFactory();
		logger =factory.createLogger();
		logger.writeLog();
	}
}
