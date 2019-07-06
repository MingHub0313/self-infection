package com.zmm.framework.service.impl;

import com.zmm.framework.mapper.SysMsgMapper;
import com.zmm.framework.model.SysMsg;
import com.zmm.framework.service.SysMsgService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.cache.annotation.CacheConfig;
import top.ibase4j.core.base.BaseServiceImpl;

/**
 * @Name SysMsgServiceImpl
 * @Author 900045
 * @Created by 2019/7/6 0006
 */
@CacheConfig(cacheNames = "sysMsg")
@Service(interfaceClass = SysMsgService.class)
public class SysMsgServiceImpl extends BaseServiceImpl<SysMsg, SysMsgMapper> implements SysMsgService {

}
