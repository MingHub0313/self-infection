package com.zmm.framework.mapper;

import com.zmm.framework.model.SysUserMenu;
import org.apache.ibatis.annotations.Param;
import top.ibase4j.core.base.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * @Name SysUserMenuMapper
 * @Author 900045
 * @Created by 2019/7/6 0006
 */
public interface SysUserMenuMapper extends BaseMapper<SysUserMenu> {

	/**
	 * 根据 用户Id 查询 菜单Id集合
	 * @param userId
	 * @return
	 */
	List<Long> queryMenuIdsByUserId(@Param("userId") Long userId);


	/**
	 * 根据用户Id 查询权限对象
	 * @param userId
	 * @return
	 */
	List<Map<String, Object>> queryPermissions(@Param("userId") Long userId);


	/**
	 * 根据用户Id 查询权限
	 * @param id
	 * @return
	 */
	List<String> queryPermission(@Param("userId") Long id);
}
