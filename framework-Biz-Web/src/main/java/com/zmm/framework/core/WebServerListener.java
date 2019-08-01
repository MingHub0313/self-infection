package com.zmm.framework.core;

import org.apache.dubbo.config.DubboShutdownHook;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.stereotype.Component;
import top.ibase4j.core.listener.ApplicationReadyListener;

/**
 * @Name WebServerListener
 * @Author 900045
 * @Created by 2019/8/1 0001
 */
@Component
public class WebServerListener extends ApplicationReadyListener {


	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof ContextStoppedEvent) {
			DubboShutdownHook.getDubboShutdownHook().doDestroy();
		} else if (event instanceof ContextClosedEvent) {
			DubboShutdownHook.getDubboShutdownHook().doDestroy();
		}
		super.onApplicationEvent(event);
	}
}
