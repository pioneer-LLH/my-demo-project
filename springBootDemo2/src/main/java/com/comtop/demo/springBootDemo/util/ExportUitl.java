package com.comtop.demo.springBootDemo.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.comtop.demo.springBootDemo.entity.reflectParameterEntity;

import net.sf.jxls.transformer.XLSTransformer;


//导出excel
public class ExportUitl {

	
	public static void main(String[] args) throws Exception {
		String tplPath = "e:/111.xlsx";
		String destPath = "e:/2222.xlsx";
		Map<String, List<reflectParameterEntity>> beanParams = new HashMap<String, List<reflectParameterEntity>>();	
		List<reflectParameterEntity> list=new ArrayList<reflectParameterEntity>();
		reflectParameterEntity r=new reflectParameterEntity();
		reflectParameterEntity r1=new reflectParameterEntity();
		reflectParameterEntity r2=new reflectParameterEntity();
		r.setClassName("试试");
		r.setMethodName("小明");
		r.setParameter(1);
		r1.setClassName("试试1");
		r1.setMethodName("小明1");
		r1.setParameter(2);
		r2.setClassName("试试2");
		r2.setMethodName("小明2");
		r2.setParameter(3);
		list.add(r);
		list.add(r1);
		list.add(r2);
		beanParams.put("data", list);
		XLSTransformer former = new XLSTransformer();	
		former.transformXLS(tplPath, beanParams, destPath);
	}


}
