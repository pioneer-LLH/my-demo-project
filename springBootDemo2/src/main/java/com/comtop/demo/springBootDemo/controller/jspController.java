package com.comtop.demo.springBootDemo.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.comtop.demo.springBootDemo.entity.testEntity;
import com.comtop.demo.springBootDemo.service.DemoService;


@Controller
@RequestMapping("/jsp")
public class jspController {

	@Resource(name="DemoService")
	private DemoService demoService;
	
	@RequestMapping("/index")
	public String getjsp() {
		System.out.println("执行index");
		return "index";
	}
	
	
	@RequestMapping("/test1")
	public String test1(Model model) {
		System.out.println("访问数据1");
		testEntity r=new testEntity();
		r=(testEntity)demoService.getObject(null);
		model.addAttribute("obj", r);
		return "index";
	}
}
