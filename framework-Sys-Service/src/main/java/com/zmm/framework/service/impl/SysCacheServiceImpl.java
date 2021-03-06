package com.zmm.framework.service.impl;

import com.zmm.framework.service.SysCacheService;
import org.apache.dubbo.config.annotation.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import top.ibase4j.core.Constants;
import top.ibase4j.core.util.CacheUtil;

/**
 * @Name SysCacheServiceImpl
 * @Author 900045
 * @Created by 2019/7/6 0006
 */
@Service(interfaceClass = SysCacheService.class)
public class SysCacheServiceImpl implements SysCacheService {
	Logger logger = LogManager.getLogger();

	/**
	 *  清缓存
	 */
	@Override
	public void flush() {
		logger.info("清缓存开始......");
		CacheUtil.getCache().delAll(Constants.CACHE_NAMESPACE + "*");
		logger.info("清缓存结束!");
	}

	/**
	 * 清缓存
	 * @param key
	 */
	@Override
	public void flush(String key) {
		logger.info("清缓存[{}]开始......", key);
		CacheUtil.getCache().delAll(Constants.CACHE_NAMESPACE + "*" + key + "*");
		if (key.contains("Permission")) {
			CacheUtil.getCache().delAll(Constants.CACHE_NAMESPACE + "*shiro_redis_cache*");
		}
		logger.info("清缓存[{}]结束!", key);
	}
}
