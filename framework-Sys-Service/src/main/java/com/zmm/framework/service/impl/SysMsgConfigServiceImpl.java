package com.zmm.framework.service.impl;

import com.zmm.framework.mapper.SysMsgConfigMapper;
import com.zmm.framework.model.SysMsgConfig;
import com.zmm.framework.service.SysMsgConfigService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.cache.annotation.CacheConfig;
import top.ibase4j.core.base.BaseServiceImpl;

/**
 * @Name SysMsgConfigServiceImpl
 * @Author 900045
 * @Created by 2019/7/6 0006
 */
@CacheConfig(cacheNames = "sysMsgConfig")
@Service(interfaceClass = SysMsgConfigService.class)
public class SysMsgConfigServiceImpl extends BaseServiceImpl<SysMsgConfig, SysMsgConfigMapper>
		implements SysMsgConfigService {

}
