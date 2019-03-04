package com.reechauto.news.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
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
	
	@Autowired
	private ResourceServerProperties resourceServerProperties;

	@PostMapping("/login/pwd")
	public ResponseData login(@RequestParam(name="username",required=true) String username, @RequestParam(name="password",required=true) String password) throws Exception {
		log.info("密码登录");
		ResponseData loginRet = loginService.loginByPassword(username, password);
		
		return loginRet;
	}
	
	@PostMapping("/login/message")
	public ResponseData loginByMessage(@RequestParam(name="mobile",required=true) String mobile, @RequestParam(name="code",required=true) String code) throws Exception {
		log.info("验证码登录");
		ResponseData loginRet = loginService.loginByCode(mobile, code);
		
		return loginRet;
	}
	
	@PostMapping("/login/sendCode")
	public ResponseData sendCode(@RequestParam(name="mobile",required=true) String mobile) throws Exception {
		log.info("发送验证码");
		ResponseData loginRet = loginService.sendMessage(mobile, resourceServerProperties.getClientId());
		
		return loginRet;
	}
	
	
}
