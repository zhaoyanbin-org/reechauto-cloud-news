package com.reechauto.cloud.news.controller.privilege;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reechauto.cloud.common.resp.ResponseData;
import com.reechauto.cloud.news.bean.menu.LeftMenuBean;
import com.reechauto.cloud.news.bean.req.privilege.MainMenuRequest;
import com.reechauto.cloud.news.service.privilege.MainMenuService;
import com.reechauto.cloud.news.utils.ErrorsUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/main")
public class MainMenuController {

	@Autowired
	private MainMenuService mainMenuService;

	@RequestMapping(value = "/leftMenus", method = RequestMethod.POST)
	public ResponseData queryMainLeftMenus(@Valid MainMenuRequest req, BindingResult result) {
		log.info(" 根据主页面左侧菜单");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(ErrorsUtil.fieldError2Map(result.getFieldErrors()));
		}
		List<LeftMenuBean> list = mainMenuService.queryMainLeft(req.getUserId());
		return ResponseData.ok().data(list);
	}
}
