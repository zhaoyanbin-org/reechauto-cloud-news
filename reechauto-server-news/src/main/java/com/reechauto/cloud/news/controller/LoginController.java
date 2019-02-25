package com.reechauto.cloud.news.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reechauto.cloud.common.resp.ResponseData;
import com.reechauto.cloud.news.entity.SysMenu;
import com.reechauto.cloud.news.entity.SysResourceScope;
import com.reechauto.cloud.news.entity.SysRole;
import com.reechauto.cloud.news.service.login.LoginService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseData loginUser(@RequestParam("userId") Long userId, @RequestParam("nickName") String nickName,
			@RequestParam("realName") String realName, @RequestParam("account") String account,
			@RequestParam("mobile") String mobile, @RequestParam("email") String email,
			@RequestParam("idcard") String idcard, @RequestParam("sex") String sex,
			@RequestParam("birthday") String birthday, @RequestParam("imgUrl") String imgUrl,
			@RequestParam("city") String city) {
		log.info("用户{}登陆并同步用户信息", userId);
		ResponseData ret = loginService.loginUser(userId, nickName, realName, account, mobile, email, idcard, sex,
				birthday, imgUrl, city);
		return ret;
	}

	/**
	 * 根据用户ID查询角色
	 * 
	 * @param req
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/roles/queryByUserId", method = RequestMethod.POST)
	public ResponseData queryRoles(@RequestParam("userId") Long userId) {
		log.info("查询角色");
		List<SysRole> list = loginService.queryRoleByUserId(userId);
		return ResponseData.ok().data(list);
	}

	/**
	 * 根据用户ID查询权限菜单
	 * 
	 * @param req
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/menus/queryByUserId", method = RequestMethod.POST)
	public ResponseData queryPrivilege(@RequestParam("userId") Long userId) {
		log.info("查询用户对应的菜单权限");
		List<SysMenu> list = loginService.queryPrivilege(userId);
		return ResponseData.ok().data(list);
	}
	
	@RequestMapping(value = "/resource/scopes", method = RequestMethod.POST)
	public ResponseData queryResourceScopse() {
		log.info("查询微服务的授权");
		List<SysResourceScope> list = loginService.queryResourceScopse();
		return ResponseData.ok().data(list);
	}

}
