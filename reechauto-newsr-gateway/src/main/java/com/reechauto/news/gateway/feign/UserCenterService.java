package com.reechauto.news.gateway.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.reechauto.cloud.common.resp.ResponseData;


@FeignClient(name="usercenter-server-user",url="http://127.0.0.1:9966/s-user")
public interface UserCenterService {

	@PostMapping("/code/mobile/send")
    public ResponseData sendMessage(@RequestParam("mobile") String mobile);
}
