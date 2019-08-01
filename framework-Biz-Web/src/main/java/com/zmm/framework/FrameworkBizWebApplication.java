package com.zmm.framework;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author 900045
 * @since 2018年4月21日 下午3:30:20
 */

@DubboComponentScan
@SpringBootApplication(scanBasePackages = {"top.ibase4j", "com.zmm.framework"})
public class FrameworkBizWebApplication {

	public static void main(String[] args) {
		System.setProperty("Log4jContextSelector", "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
		SpringApplication.run(FrameworkBizWebApplication.class, args);
	}

}
