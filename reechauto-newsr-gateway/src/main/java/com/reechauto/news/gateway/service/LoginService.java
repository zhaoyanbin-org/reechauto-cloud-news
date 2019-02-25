package com.reechauto.news.gateway.service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.google.gson.internal.LinkedTreeMap;
import com.reechauto.cloud.common.resp.ResponseData;
import com.reechauto.cloud.common.resp.ToeknBean;
import com.reechauto.cloud.common.utils.gson.GsonUtil;
import com.reechauto.cloud.common.utils.str.BasicTokenUtil;
import com.reechauto.news.gateway.config.Constant;
import com.reechauto.news.gateway.feign.AuthorizationService;
import com.reechauto.news.gateway.feign.NewsUserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LoginService {
	@Autowired
	private ResourceServerProperties resourceServerProperties;
	@Autowired
	private AuthorizationService authorizationService;
	@Autowired
	private NewsUserService newsUserService;
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@SuppressWarnings("unchecked")
	public ResponseData login(String username, String password) throws UnsupportedEncodingException {
		String authorizationStr = BasicTokenUtil.authorizationBasic(resourceServerProperties.getClientId(),
				resourceServerProperties.getClientSecret());
		ToeknBean token = authorizationService.login(authorizationStr, "password", username, password);
		Object userObj = authorizationService.userInfo(BasicTokenUtil.authorizationBearer(token.getAccess_token()));
		ResponseData serverUser = GsonUtil.GsonToBean(GsonUtil.GsonString(userObj), ResponseData.class);
		if (1000 != serverUser.getCode()) {
			log.info("获取远程用户信息失败");
			throw new RuntimeException("获取远程用户信息失败");
		}

		Map<String, Object> user = (LinkedTreeMap<String, Object>) serverUser.getData().get("context");
		List<LinkedTreeMap<String, Object>> accountInfo = (ArrayList<LinkedTreeMap<String, Object>>) user
				.get("accountInfo");

		String account = "";
		String mobile = "";
		String email = "";
		String idcard = "";
		for (LinkedTreeMap<String, Object> e : accountInfo) {
			if ("mobile".equals(e.get("accountType").toString())) {
				mobile = e.get("accountNum").toString();
				continue;
			}
			if ("account".equals(e.get("accountType").toString())) {
				account = e.get("accountNum").toString();
				continue;
			}
			if ("email".equals(e.get("accountType").toString())) {
				email = e.get("accountNum").toString();
				continue;
			}
			if ("idcard".equals(e.get("accountType").toString())) {
				idcard = e.get("accountNum").toString();
				continue;
			}
		}

		Long userId = Float.valueOf(user.get("userId").toString()).longValue();
		ResponseData userRet = newsUserService.loginUser(userId, "" + user.get("nickName"), "" + user.get("realName"),
				account, mobile, email, idcard, "" + user.get("sex"), "" + user.get("birthday"),
				"" + user.get("imgUrl"), "" + user.get("city"));

		//获取授权
		ResponseData privilegeRet = newsUserService.queryPrivilege(userId);
		if (1000 != privilegeRet.getCode()) {
			throw new RuntimeException("获取用户权限失败");
		} else {
			userRet.data("menus", privilegeRet.getData().get("context"));
			redisTemplate.opsForValue().set(Constant.USER_MENUS+token.getAccess_token(), privilegeRet.getData().get("context"), token.getExpires_in(),TimeUnit.SECONDS);
		}
		//获取角色
		ResponseData roleRet = newsUserService.queryRoles(userId);
		if (1000 != roleRet.getCode()) {
			throw new RuntimeException("获取用户角色失败");
		} else {
			userRet.data("roles", roleRet.getData().get("context"));
			redisTemplate.opsForValue().set(Constant.USER_ROLES+token.getAccess_token(), roleRet.getData().get("context"), token.getExpires_in(),TimeUnit.SECONDS);
		}

		userRet.data("token", token);
		return userRet;
	}
}
