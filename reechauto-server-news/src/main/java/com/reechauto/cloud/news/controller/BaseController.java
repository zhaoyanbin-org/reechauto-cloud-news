package com.reechauto.cloud.news.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("news")
public class BaseController {
   protected  Logger logger = LoggerFactory.getLogger(getClass());
}
