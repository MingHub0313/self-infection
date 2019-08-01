package com.zmm.framework.mapper;

import com.zmm.framework.model.SysRoleMenu;
import org.apache.ibatis.annotations.Param;
import top.ibase4j.core.base.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * @Name SysRoleMenuMapper
 * @Author 900045
 * @Created by 2019/7/6 0006
 */
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {

	/**
	 * 根据 角色Id 查询菜单Id集合
	 * @param roleId
	 * @return
	 */
	List<Long> queryMenuIdsByRoleId(@Param("roleId") Long roleId);


	/**
	 * 根据 角色 Id 查询权限对象
	 * @param roleId
	 * @return
	 */
	List<Map<String, Object>> queryPermissions(@Param("roleId") Long roleId);

	/**
	 *  根据 角色 id 查询 权限
	 * @param id
	 * @return
	 */
	List<String> queryPermission(@Param("roleId") Long id);
}
