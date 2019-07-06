package com.zmm.framework.service.impl;

import com.zmm.framework.mapper.SysNewsMapper;
import com.zmm.framework.model.SysNews;
import com.zmm.framework.service.SysNewsService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.cache.annotation.CacheConfig;
import top.ibase4j.core.base.BaseServiceImpl;

/**
 * @Name SysNewsServiceImpl
 * @Author 900045
 * @Created by 2019/7/6 0006
 */
@CacheConfig(cacheNames = "sysNews")
@Service(interfaceClass = SysNewsService.class)
public class SysNewsServiceImpl extends BaseServiceImpl<SysNews, SysNewsMapper> implements SysNewsService {

}
