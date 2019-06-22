package com.wez.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wez.springcloud.entities.Dept;
import com.wez.springcloud.service.DeptService;

@RestController
public class DeptController {

	@Autowired
	private DeptService service;
	
	// 一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
	@HystrixCommand(fallbackMethod="processHystrixGet")
	@RequestMapping(value="/dept/get/{id}", method=RequestMethod.GET)
	public Dept get(@PathVariable("id") Long id) {
		Dept dept = service.get(id);
		
		if (dept == null) {
			throw new RuntimeException("该ID" + id + "没有对应信息，null");
		}
		return dept;
	}
	
	public Dept processHystrixGet(@PathVariable("id") Long id) {
		Dept errorObj = new Dept();
		errorObj.setDeptno(id);
		errorObj.setDname("该ID" + id + "没有对应信息，null --@HystrixCommond");
		errorObj.setDb_source("no this database in MySQL");
		return errorObj;
	}
	
	
}
