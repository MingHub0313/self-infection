package com.zmm.framework.core;

import org.apache.dubbo.config.DubboShutdownHook;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import top.ibase4j.core.listener.ApplicationReadyListener;

/**
 * @Name BizServerListener
 * @Author 900045
 * @Created by 2019/7/6 0006
 */
public class BizServerListener extends ApplicationReadyListener {

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
