package com.reechauto.news.gateway.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.reechauto.cloud.common.resp.ResponseData;

@FeignClient(name = "server-news")
public interface NewsUserService {

	@PostMapping("/login/user")
	public ResponseData loginUser(@RequestParam("userId") Long userId, @RequestParam("nickName") String nickName,
			@RequestParam("realName") String realName, @RequestParam("account") String account,
			@RequestParam("mobile") String mobile, @RequestParam("email") String email,
			@RequestParam("idcard") String idcard, @RequestParam("sex") String sex,
			@RequestParam("birthday") String birthday, @RequestParam("imgUrl") String imgUrl,
			@RequestParam("city") String city);

	@PostMapping("/login/roles/queryByUserId")
	public ResponseData queryRoles(@RequestParam("userId") Long userId);

	@PostMapping("/login/menus/queryByUserId")
	public ResponseData queryPrivilege(@RequestParam("userId") Long userId);
	
}
