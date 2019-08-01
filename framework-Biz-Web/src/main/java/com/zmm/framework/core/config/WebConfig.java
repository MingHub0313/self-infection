package com.zmm.framework.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import top.ibase4j.core.config.WebMvcConfig;
import top.ibase4j.core.interceptor.TokenInterceptor;
import top.ibase4j.core.interceptor.provider.EventInterceptor;

/**
 * @Name WebConfig
 * @Author 900045
 * @Created by 2019/8/1 0001
 */
@Configuration
@ComponentScan("com.zmm.framework.web")
public class WebConfig extends WebMvcConfig {

	@Override
	@Bean
	public EventInterceptor eventInterceptor() {
		return new EventInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		super.addInterceptors(registry);
		registry.addInterceptor(new TokenInterceptor()).addPathPatterns("/**").excludePathPatterns("/*.ico",
				"/*/api-docs", "/swagger**", "/swagger-resources/**", "/webjars/**", "/configuration/**");
	}
}
