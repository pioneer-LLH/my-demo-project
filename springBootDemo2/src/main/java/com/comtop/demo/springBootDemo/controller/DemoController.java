package com.comtop.demo.springBootDemo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comtop.demo.springBootDemo.entity.testEntity;
import com.comtop.demo.springBootDemo.service.DemoService;
import com.comtop.demo.springBootDemo.util.ExceptionUtil;
//这是一个测试
@RestController
@RequestMapping("/demoController")
public class DemoController {
	
	
	@Resource(name="DemoService")
	private DemoService demoService;
	@RequestMapping("/test")
	public String test() {
		try {
			System.out.println("执行try前部分");
			Class<?> c=Class.forName("test");
			c.getMethod("ss", String.class);
			System.out.println("执行try后部分");
		} catch (Exception e) {
			return ExceptionUtil.getTrace(e);
		}finally {
			System.out.println("执行了test");
		}
		return null;
	}
	
	@RequestMapping("/test1")
	public List<Map<String, Object>> test1() {
		System.out.println("访问数据");
		return demoService.getAll();
	}
	
	@RequestMapping("/test2")
	public Map<String, Object> test2() {
		System.out.println("访问数据2");
		Map<String, Object> map=new HashMap<String, Object>();
		testEntity test=new testEntity();
		test=(testEntity)demoService.getObject(testEntity.class);
		map.put("obj", test);
		return map;
	}
}
