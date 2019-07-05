package com.zmm.framework.service;

import com.zmm.framework.model.SysParam;
import top.ibase4j.core.base.BaseService;

import java.util.Map;

/**
 * @Name SysParamService
 * @Author 900045
 * @Created by 2019/7/5 0005
 */
public interface SysParamService extends BaseService<SysParam> {

	/**
	 * 获取参数
	 * @return
	 */
	Map<String, String> getAllParams();

	/**
	 * 根据 key 查询名称
	 * @param key
	 * @return
	 */
	String getName(String key);

	/**
	 * 根据 key 获取值
	 * @param key
	 * @return
	 */
	String getValue(String key);


	/**
	 * 根据 key 默认的值 获取值
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	String getValue(String key, String defaultValue);
}
