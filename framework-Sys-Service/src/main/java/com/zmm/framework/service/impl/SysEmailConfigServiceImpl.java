package com.zmm.framework.service.impl;

import com.zmm.framework.mapper.SysEmailConfigMapper;
import com.zmm.framework.model.SysEmailConfig;
import com.zmm.framework.service.SysEmailConfigService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.cache.annotation.CacheConfig;
import top.ibase4j.core.base.BaseServiceImpl;

/**
 * @Name SysEmailConfigServiceImpl
 * @Author 900045
 * @Created by 2019/7/6 0006
 */
@CacheConfig(cacheNames = "sysEmailConfig")
@Service(interfaceClass = SysEmailConfigService.class)
public class SysEmailConfigServiceImpl extends BaseServiceImpl<SysEmailConfig, SysEmailConfigMapper>
		implements SysEmailConfigService {

}
