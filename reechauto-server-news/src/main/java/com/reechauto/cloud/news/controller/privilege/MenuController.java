package com.reechauto.cloud.news.controller.privilege;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.reechauto.cloud.common.resp.ResponseData;
import com.reechauto.cloud.news.bean.req.privilege.MenuDelRequest;
import com.reechauto.cloud.news.service.privilege.MenuService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	public ResponseData delMenuById(@Valid MenuDelRequest req, BindingResult result) {
		log.info("删除菜单及其子菜单");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(result.getAllErrors());
		}
		menuService.delMenu(req);
		return ResponseData.ok();
	}
}
