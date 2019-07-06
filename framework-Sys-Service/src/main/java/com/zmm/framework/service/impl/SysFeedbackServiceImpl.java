package com.zmm.framework.service.impl;

import com.zmm.framework.mapper.SysFeedbackMapper;
import com.zmm.framework.model.SysFeedback;
import com.zmm.framework.service.SysFeedbackService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.cache.annotation.CacheConfig;
import top.ibase4j.core.base.BaseServiceImpl;

/**
 * @Name SysFeedbackServiceImpl
 * @Author 900045
 * @Created by 2019/7/6 0006
 */
@CacheConfig(cacheNames = "SysFeedback")
@Service(interfaceClass = SysFeedbackService.class)
public class SysFeedbackServiceImpl extends BaseServiceImpl<SysFeedback, SysFeedbackMapper>
		implements SysFeedbackService {

}
