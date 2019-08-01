package com.zmm.framework.mapper;

import com.zmm.framework.model.SysMenu;
import top.ibase4j.core.base.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * @Name SysMenuMapper
 * @Author 900045
 * @Created by 2019/7/6 0006
 */
public interface SysMenuMapper extends BaseMapper<SysMenu>{


	/**
	 * 获取所有权限
	 * @return
	 */
	List<Map<String, String>> getPermissions();
}
