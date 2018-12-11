package com.comtop.demo.springBootDemo.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.comtop.demo.springBootDemo.dao.demo.DemoDao;
import com.comtop.demo.springBootDemo.entity.testEntity;
import com.comtop.demo.springBootDemo.service.DemoService;

@Service("DemoService")
public class DemoServiceImpl implements DemoService{

	@Resource
	private DemoDao demoDao;
	
	@Override
	public List<Map<String, Object>> getAll() {
		return demoDao.getAll();
	}

	@Override
	public Object getObject(Class<?> cls) {
		Object obj = demoDao.getObject();
		if(obj==null) {
			try {
				return cls.newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return obj;
	}

}
