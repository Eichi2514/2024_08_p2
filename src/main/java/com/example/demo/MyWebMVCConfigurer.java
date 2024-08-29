package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.interceptor.BeforeActionInterceptor;
import com.example.demo.interceptor.NeedLoginInterceptor;
import com.example.demo.interceptor.NeedLogoutInterceptor;

@Configuration
public class MyWebMVCConfigurer implements WebMvcConfigurer {

	@Autowired
	BeforeActionInterceptor beforeActionInterceptor;

	@Autowired
	NeedLoginInterceptor needLoginInterceptor;

	@Autowired
	NeedLogoutInterceptor needLogoutInterceptor;

	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(beforeActionInterceptor).addPathPatterns("/**").excludePathPatterns("/resource/**")
				.excludePathPatterns("/error");

		registry.addInterceptor(needLoginInterceptor).addPathPatterns("/usr/member/doLogout");

		registry.addInterceptor(needLogoutInterceptor).addPathPatterns("/usr/member/doLogin").addPathPatterns("/usr/member/join")
				.addPathPatterns("/usr/member/doJoin");

	}

}