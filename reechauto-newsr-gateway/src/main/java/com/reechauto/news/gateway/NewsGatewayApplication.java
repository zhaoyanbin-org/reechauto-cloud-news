package com.reechauto.news.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableZuulProxy
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@ComponentScan(value= {"com.reechauto.cloud","com.reechauto.news.gateway"})
public class NewsGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsGatewayApplication.class, args);
	}

}

