package com.zmm.framework.mapper;

import com.zmm.framework.model.SysMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Name SysAuthorizeMapper
 * @Author 900045
 * @Created by 2019/7/6 0006
 */
public interface SysAuthorizeMapper {

	/**
	 * 根据 用户Id 权限删除用户菜单
	 * @param userId
	 * @param permission
	 */
	void deleteUserMenu(@Param("userId") Long userId, @Param("permission") String permission);

	/**
	 * 根据 用户Id 删除用户角色
	 * @param userId
	 */
	void deleteUserRole(@Param("userId") Long userId);


	/**
	 * 根据 角色Id和权限删除角色菜单
	 * @param roleId
	 * @param permission
	 */
	void deleteRoleMenu(@Param("roleId") Long roleId, @Param("permission") String permission);


	/**
	 * 根据 用户Id 查询认证
	 * @param userId
	 * @return
	 */
	List<Long> getAuthorize(@Param("userId") Long userId);


	/**
	 * 根据用户ID 查询权限
	 * @param userId
	 * @return
	 */
	List<String> queryPermissionByUserId(@Param("userId") Long userId);


	/**
	 * 查询系统菜单
	 * @return
	 */
	List<SysMenu> queryMenusPermission();
}
