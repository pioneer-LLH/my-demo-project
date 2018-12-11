package com.comtop.demo.springBootDemo.dao.demo;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;


@Repository
public interface DemoDao {
	public List<Map<String, Object>> getAll();
	
	public Object getObject();
}
