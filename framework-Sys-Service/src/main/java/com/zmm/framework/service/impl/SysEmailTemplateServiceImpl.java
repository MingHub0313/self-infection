package com.zmm.framework.service.impl;

import com.zmm.framework.mapper.SysEmailTemplateMapper;
import com.zmm.framework.model.SysEmailTemplate;
import com.zmm.framework.service.SysEmailTemplateService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.cache.annotation.CacheConfig;
import top.ibase4j.core.base.BaseServiceImpl;

/**
 * @Name SysEmailTemplateServiceImpl
 * @Author 900045
 * @Created by 2019/7/6 0006
 */
@CacheConfig(cacheNames = "sysEmailTemplate")
@Service(interfaceClass = SysEmailTemplateService.class)
public class SysEmailTemplateServiceImpl extends BaseServiceImpl<SysEmailTemplate, SysEmailTemplateMapper>
		implements SysEmailTemplateService {

}
