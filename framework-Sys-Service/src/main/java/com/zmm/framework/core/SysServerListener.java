package com.zmm.framework.core;

import com.zmm.framework.service.SysCacheService;
import com.zmm.framework.service.SysUserService;
import org.apache.dubbo.config.DubboShutdownHook;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import top.ibase4j.core.listener.ApplicationReadyListener;

/**
 * @Name SysServerListener
 * @Author 900045
 * @Created by 2019/7/6 0006
 */
public class SysServerListener extends ApplicationReadyListener {

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		// 应用已启动完成
		if (event instanceof ApplicationReadyEvent) {
			ConfigurableApplicationContext context = ((ApplicationReadyEvent)event).getApplicationContext();
			context.getBean(SysCacheService.class).flush();
			context.getBean(SysUserService.class).init();
		} else if (event instanceof ContextStoppedEvent) {
			// 应用停止
			DubboShutdownHook.getDubboShutdownHook().doDestroy();
		} else if (event instanceof ContextClosedEvent) {
			// 应用关闭
			DubboShutdownHook.getDubboShutdownHook().doDestroy();
		}
		super.onApplicationEvent(event);
	}
}
