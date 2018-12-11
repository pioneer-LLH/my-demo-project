package com.comtop.demo.springBootDemo.service;

import java.util.List;
import java.util.Map;

public interface DemoService {
	public List<Map<String, Object>> getAll();
	
	public Object getObject(Class<?> cls);
}
