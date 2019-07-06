package com.zmm.framework.service.impl;

import com.zmm.framework.mapper.SysNoticeMapper;
import com.zmm.framework.model.SysNotice;
import com.zmm.framework.service.SysNoticeService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.cache.annotation.CacheConfig;
import top.ibase4j.core.base.BaseServiceImpl;

/**
 * @Name SysNoticeServiceImpl
 * @Author 900045
 * @Created by 2019/7/6 0006
 */
@CacheConfig(cacheNames = "sysNotice")
@Service(interfaceClass = SysNoticeService.class)
public class SysNoticeServiceImpl extends BaseServiceImpl<SysNotice, SysNoticeMapper> implements SysNoticeService {

}
