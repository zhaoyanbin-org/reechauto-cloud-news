package com.reechauto.news.gateway.config.resource;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.expression.OAuth2WebSecurityExpressionHandler;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.reechauto.cloud.common.resp.ResponseData;
import com.reechauto.news.gateway.config.Constant;
import com.reechauto.news.gateway.feign.NewsUserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	@Autowired
	private ResourceServerProperties resourceServerProperties;
	@Autowired
	private AccessDeniedHandler reechAccessDeniedHandler;
	@Autowired
	private AuthenticationEntryPoint reechAuthenticationEntryPoint;
	@Autowired
	private OAuth2WebSecurityExpressionHandler oAuth2WebSecurityExpressionHandler;
	@Autowired
	private NewsUserService newsUserService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

//	@Bean
//	@Qualifier("authorizationHeaderRequestMatcher")
//	public RequestMatcher authorizationHeaderRequestMatcher() {
//		return new RequestHeaderRequestMatcher("Authorization");
//	}

	@Bean
	public OAuth2WebSecurityExpressionHandler oAuth2WebSecurityExpressionHandler(
			ApplicationContext applicationContext) {
		OAuth2WebSecurityExpressionHandler expressionHandler = new OAuth2WebSecurityExpressionHandler();
		expressionHandler.setApplicationContext(applicationContext);
		return expressionHandler;
	}
	
	@Bean
    public RemoteTokenServices remoteTokenServices() {
        RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
        return remoteTokenServices;
    }
	

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		log.info("用户中心微服务的ResourceId：==>" + resourceServerProperties.getResourceId());
		resources.resourceId(resourceServerProperties.getResourceId());
		resources.accessDeniedHandler(reechAccessDeniedHandler).authenticationEntryPoint(reechAuthenticationEntryPoint);
		resources.expressionHandler(oAuth2WebSecurityExpressionHandler);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().exceptionHandling().accessDeniedHandler(reechAccessDeniedHandler)
				.authenticationEntryPoint(reechAuthenticationEntryPoint);
		
		ResponseData scopRet = newsUserService.queryResourceScopse();

		http.authorizeRequests().antMatchers(Constant.URL_PERMITALL).permitAll();
		http.authorizeRequests().antMatchers("/news/login/**").denyAll();
		//http.authorizeRequests().antMatchers("/news/reech/depart").access("#oauth2.hasAnyScope('abc,aab') and @permissionService.hasPermission(request,authentication)");
		if(1000==scopRet.getCode()) {
			List<LinkedHashMap<String, Object>> list = (ArrayList<LinkedHashMap<String, Object>>) scopRet.getData().get("context");
			if(!CollectionUtils.isEmpty(list)) {
				list.forEach(e ->{
					String url = e.get("url").toString();
					String scope = e.get("scope").toString();
					try {
						http.authorizeRequests().antMatchers(url).access("#oauth2.hasAnyScope('"+scope+"') and @permissionService.hasPermission(request,authentication)");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				});
			}
		}
		
		http.authorizeRequests().anyRequest().access("@permissionService.hasPermission(request,authentication)");
		http.authorizeRequests().anyRequest().authenticated();
		
	}

}
