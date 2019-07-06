package com.zmm.framework.service.impl;

import com.zmm.framework.mapper.SysArticleMapper;
import com.zmm.framework.model.SysArticle;
import com.zmm.framework.service.SysArticleService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.cache.annotation.CacheConfig;
import top.ibase4j.core.base.BaseServiceImpl;

/**
 * <p>文章  服务实现类</p>
 * @Name SysArticleServiceImpl
 * @Author 900045
 * @Created by 2019/7/6 0006
 */
@CacheConfig(cacheNames = "sysArticle")
@Service(interfaceClass = SysArticleService.class)
public class SysArticleServiceImpl extends BaseServiceImpl<SysArticle, SysArticleMapper> implements SysArticleService {
}
