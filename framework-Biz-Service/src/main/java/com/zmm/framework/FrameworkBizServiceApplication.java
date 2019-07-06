package com.zmm.framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @Name FrameworkBizServiceApplication
 * @Author 900045
 * @Created by 2019/7/6 0006
 */
@SpringBootApplication(scanBasePackages = {"top.ibase4j", "com.zmm.framework"})
public class FrameworkBizServiceApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		System.setProperty("Log4jContextSelector", "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
		SpringApplication.run(FrameworkBizServiceApplication.class, args);
	}

}
