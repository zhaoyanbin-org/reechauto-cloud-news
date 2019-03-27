package com.reechauto.cloud.news;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class NewsApplication {

	public static void main(String[] args) {
		log.info("资源服务器--ServerNews启动...");
		SpringApplication.run(NewsApplication.class, args);
	}

}

