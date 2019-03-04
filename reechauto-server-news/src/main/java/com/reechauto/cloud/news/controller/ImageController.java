package com.reechauto.cloud.news.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.reechauto.cloud.common.resp.ResponseData;
import com.reechauto.cloud.common.utils.code.IdGenerator;
import com.reechauto.cloud.common.utils.date.DateUtil;
import com.reechauto.cloud.news.service.image.OSSService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/file")
public class ImageController extends BaseController {

	@Autowired
	private OSSService oSSService;
	
	@PostMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseData handleFileUpload(@RequestPart(value = "file") MultipartFile file) {
		String fname = IdGenerator.uuid();
		String fileDir = "data"+DateUtil.getCurrentDate("yyyyMMdd");
		String fullPath = oSSService.uploadImg2Oss(file, fileDir, fname);
		return ResponseData.ok().data(fullPath);
	}
}
