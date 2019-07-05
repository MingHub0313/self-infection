package com.zmm.framework.service;

import com.zmm.framework.model.SysMenu;
import com.zmm.framework.model.SysRoleMenu;
import com.zmm.framework.model.SysUserMenu;
import com.zmm.framework.model.SysUserRole;

import java.util.List;
import java.util.Map;

/**
 * @Name SysAuthorizeService
 * @Author 900045
 * @Created by 2019/7/5 0005
 */
public interface SysAuthorizeService {

	/**
	 * 根据用户id 查询菜单的id集合
	 * @param userId
	 * @return
	 */
	List<String> queryMenuIdsByUserId(Long userId);


	/**
	 * 更新系统的菜单
	 * @param sysUserMenus
	 */
	void updateUserMenu(List<SysUserMenu> sysUserMenus);


	/**
	 * 更新用户权限
	 * @param sysUserMenus
	 */
	void updateUserPermission(List<SysUserMenu> sysUserMenus);

	/**
	 * 根据 用户id 获取角色信息
	 * @param userId
	 * @return
	 */
	List<SysUserRole> getRolesByUserId(Long userId);

	/**
	 * 批量更新用户角色
	 * @param sysUserRoles
	 */
	void updateUserRole(List<SysUserRole> sysUserRoles);

	/**
	 * 根据 角色id 查询菜单id集合
	 * @param roleId
	 * @return
	 */
	List<String> queryMenuIdsByRoleId(Long roleId);


	/**
	 * 批量更新角色对应的菜单
	 * @param sysRoleMenus
	 */
	void updateRoleMenu(List<SysRoleMenu> sysRoleMenus);


	/**
	 * 批量更新角色的权限
	 * @param sysRoleMenus
	 */
	void updateRolePermission(List<SysRoleMenu> sysRoleMenus);

	/**
	 * 根据 用户Id 查询是否授权
	 * @param userId
	 * @return
	 */
	List<SysMenu> queryAuthorizeByUserId(Long userId);

	/**
	 * 查询授权
	 * @return
	 */
	List<SysMenu> queryMenusPermission();

	/**
	 * 根据用户id 查询权限信息集合
	 * @param userId
	 * @return
	 */
	List<String> queryPermissionByUserId(Long userId);

	/**
	 * 根据角色id 查询授权id集合
	 * @param roleId
	 * @return
	 */
	List<String> queryRolePermission(Long roleId);

	/**
	 * 根据用户id查询用户授权
	 * @param userId
	 * @return
	 */
	List<String> queryUserPermission(Long userId);

	/**
	 * 根据 用户菜单查询用户授权
	 * @param record
	 * @return
	 */
	List<Map<String, Object>> queryUserPermissions(SysUserMenu record);

	/**
	 * 根据 角色菜单查询角色授权
	 * @param record
	 * @return
	 */
	List<Map<String, Object>> queryRolePermissions(SysRoleMenu record);
}
