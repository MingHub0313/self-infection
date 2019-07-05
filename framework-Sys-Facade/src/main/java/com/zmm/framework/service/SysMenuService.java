package com.zmm.framework.service;

import com.zmm.framework.model.SysMenu;
import top.ibase4j.core.base.BaseService;

import java.util.List;
import java.util.Map;

/**
 * @Name SysMenuService
 * @Author 900045
 * @Created by 2019/7/5 0005
 */
public interface SysMenuService extends BaseService<SysMenu> {
	/**
	 * 获取所有权限选项(value-text)
	 * @return
	 */
	List<Map<String, String>> getPermissions();

	/**
	 * 根据 条件获取数据
	 * @param param
	 * @return
	 */
	List<?> queryTreeList(Map<String, Object> param);
}
