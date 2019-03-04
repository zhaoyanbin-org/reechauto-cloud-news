package com.reechauto.news.gateway.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.reechauto.cloud.common.resp.ResponseData;
import com.reechauto.cloud.common.resp.ToeknBean;


@FeignClient(name="reechauto-auth",url="${security.oauth2.uri}")
public interface AuthorizationService {

	@PostMapping("/oauth/token")
    public ToeknBean login(@RequestHeader("Authorization")String authorization,@RequestParam(name="grant_type",required=true,defaultValue="password") String grant_type,@RequestParam("username") String username,@RequestParam("password") String password);
	
	
	@PostMapping("/mobile/token")
    public ToeknBean loginByCode(@RequestHeader("Authorization")String authorization,@RequestParam("mobile") String mobile,@RequestParam("vcode") String vcode);
	
	
	@PostMapping("/userinfo")
    public Object userInfo(@RequestHeader("Authorization")String authorization);
	
	
	@PostMapping("/nologin/mobile/send")
    public ResponseData sendMessage(@RequestParam("mobile") String mobile);
}
