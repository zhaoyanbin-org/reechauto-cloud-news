package com.reechauto.news.gateway.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import com.reechauto.news.gateway.config.Constant;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("permissionService")
public class PermissionService {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	private AntPathMatcher antPathMatcher = new AntPathMatcher();

	@SuppressWarnings("unchecked")
	public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
		String requestUrl = request.getRequestURI();
		OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails)authentication.getDetails();

		Object menusObj = redisTemplate.opsForValue().get(Constant.USER_MENUS + details.getTokenValue());
		List<LinkedHashMap<String, Object>> list = null;
		if (menusObj != null) {
			list = (ArrayList<LinkedHashMap<String, Object>>)menusObj;
		} else {
			log.info("获取用户权限失败,请重新登录");
	        throw new RuntimeException("获取用户权限失败,请重新登录");
		}

		boolean hasPermission = false;

		if (CollectionUtils.isEmpty(list)) {
			return hasPermission;
		}
		for (LinkedHashMap<String, Object> menu : list) {
			String url = "" + menu.get("url");
			if (antPathMatcher.match(url, requestUrl)) {
				hasPermission = true;
				break;
			}
		}

		return hasPermission;
	}

}
