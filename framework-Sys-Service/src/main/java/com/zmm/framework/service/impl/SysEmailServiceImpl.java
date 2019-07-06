package com.zmm.framework.service.impl;

import com.zmm.framework.mapper.SysEmailMapper;
import com.zmm.framework.model.SysEmail;
import com.zmm.framework.service.SysEmailService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.cache.annotation.CacheConfig;
import top.ibase4j.core.base.BaseServiceImpl;

/**
 * @Name SysEmailServiceImpl
 * @Author 900045
 * @Created by 2019/7/6 0006
 */
@CacheConfig(cacheNames = "sysEmail")
@Service(interfaceClass = SysEmailService.class)
public class SysEmailServiceImpl extends BaseServiceImpl<SysEmail, SysEmailMapper> implements SysEmailService {

}
