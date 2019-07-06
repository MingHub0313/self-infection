package com.zmm.framework.service.impl;

import com.zmm.framework.service.SchedulerService;
import org.apache.dubbo.config.annotation.Service;
import top.ibase4j.core.support.scheduler.SchedulerServiceImpl;

/**
 * @Name ScheduledServiceImpl
 * @Author 900045
 * @Created by 2019/7/6 0006
 */
@Service(interfaceClass = SchedulerService.class)
public class ScheduledServiceImpl extends SchedulerServiceImpl implements SchedulerService {
}
