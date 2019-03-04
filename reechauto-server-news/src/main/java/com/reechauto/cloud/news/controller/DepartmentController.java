package com.reechauto.cloud.news.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reechauto.cloud.common.resp.ResponseData;
import com.reechauto.cloud.news.bean.ReechDepartment;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class DepartmentController {

  
	@PostMapping("/reech/depart")
	public ResponseData getDepartmentInfo(String departMentId) {
		log.info("返回部门信息");
		ReechDepartment depart = new ReechDepartment();
		depart.setDepartmentId(departMentId);
		depart.setDepartmentName("智能网联");
		depart.setHeader("大BOSS");
		return ResponseData.ok().data(depart);
	}
	
}
