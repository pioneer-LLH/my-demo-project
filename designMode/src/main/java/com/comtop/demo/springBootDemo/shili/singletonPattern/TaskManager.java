package com.comtop.demo.springBootDemo.shili.singletonPattern;

//普通单列模式
public class TaskManager {
	private static TaskManager tm = null;
	private TaskManager() {}
	public void displayProcesses() {}
	public void displayServices() {}
	
	public static TaskManager getInstance() {
		if(tm == null) {
			tm = new TaskManager();
		}
		return tm;
	}
}
