package com.zmm.framework.service;

import com.zmm.framework.model.SysDic;
import top.ibase4j.core.base.BaseService;

import java.util.List;
import java.util.Map;

/**
 * @Name SysDicService
 * @Author 900045
 * @Created by 2019/7/5 0005
 */
public interface SysDicService extends BaseService<SysDic> {


	/**
	 * 查询字典数据
	 * @return
	 */
	Map<String, Map<String, String>> getAllDic();

	/**
	 * 根据条件查询字典数据
	 * @param params
	 * @return
	 */
	Map<String, String> queryDicByTypeMap(Map<String, Object> params);


	/**
	 * 根据 key 从缓存中取数据
	 * @param key
	 * @return
	 */
	Map<String, String> queryDicByType(String key);


	/**
	 * 根据 条件获取 内容
	 * @param parentType
	 * @param parentCode
	 * @param type
	 * @param code
	 * @return
	 */
	String getText(String parentType, String parentCode, String type, String code);

	/**
	 * 根据 条件获取字典数据
	 * @param parentType
	 * @param parentCode
	 * @param type
	 * @return
	 */
	List<SysDic> getDics(String parentType, String parentCode, String type);
}
