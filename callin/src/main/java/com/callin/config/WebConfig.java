package com.callin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.callin.interceptor.CallinInterceptor;
import com.callin.interceptor.LoginInterceptor;

@Component
public class WebConfig implements WebMvcConfigurer{
	
	private final CallinInterceptor callinInterceptor;
	private final LoginInterceptor loginInterceptor;
	@Autowired
	public WebConfig(CallinInterceptor callinInterceptor
					,LoginInterceptor loginInterceptor) {
		this.callinInterceptor = callinInterceptor;
		this.loginInterceptor = loginInterceptor;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(callinInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/css/**")
				.excludePathPatterns("/js/**")
				.excludePathPatterns("/dist/**")
				.excludePathPatterns("/plugins/**")
				.excludePathPatterns("/AdminLTE/**");
		
		registry.addInterceptor(loginInterceptor)
				.addPathPatterns("/**")
				//.excludePathPatterns("/")
				.excludePathPatterns("/login")
				.excludePathPatterns("/join")
				.excludePathPatterns("/css/**")
				.excludePathPatterns("/js/**")
				.excludePathPatterns("/dist/**")
				.excludePathPatterns("/plugins/**")
				.excludePathPatterns("/joinIdCheck")
				.excludePathPatterns("/AdminLTE/**");
		
		WebMvcConfigurer.super.addInterceptors(registry);
	}
}
