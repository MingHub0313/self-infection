package com.zmm.framework.service;

/**
 * @Name SysCacheService
 * @Author 900045
 * @Created by 2019/7/5 0005
 */
public interface SysCacheService {
	/**
	 * 清除缓存
	 */
	void flush();

	/**
	 * 清除缓存
	 * @param key
	 */
	void flush(String key);
}
