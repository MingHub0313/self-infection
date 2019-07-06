package com.zmm.framework.service.impl;

import com.zmm.framework.mapper.SysUnitMapper;
import com.zmm.framework.model.SysUnit;
import com.zmm.framework.service.SysUnitService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.cache.annotation.CacheConfig;
import top.ibase4j.core.base.BaseServiceImpl;

/**
 * @Name SysUnitServiceImpl
 * @Author 900045
 * @Created by 2019/7/6 0006
 */
@CacheConfig(cacheNames = "sysUnit")
@Service(interfaceClass = SysUnitService.class)
public class SysUnitServiceImpl extends BaseServiceImpl<SysUnit, SysUnitMapper> implements SysUnitService {

}
