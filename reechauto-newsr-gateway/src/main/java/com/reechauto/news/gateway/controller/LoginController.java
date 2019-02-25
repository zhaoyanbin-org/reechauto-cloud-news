package com.reechauto.news.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reechauto.cloud.common.resp.ResponseData;
import com.reechauto.news.gateway.service.LoginService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class LoginController {
	@Autowired
	private LoginService loginService;

	@PostMapping("/login/pwd")
	public ResponseData login(@RequestParam(name="username",required=true) String username, @RequestParam(name="password",required=true) String password) throws Exception {
		log.info("密码登录");
		ResponseData loginRet = loginService.login(username, password);
		
		return loginRet;
	}
}
