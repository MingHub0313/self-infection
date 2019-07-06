package com.zmm.framework.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zmm.framework.mapper.SysRoleMapper;
import com.zmm.framework.mapper.SysRoleMenuMapper;
import com.zmm.framework.mapper.SysUserRoleMapper;
import com.zmm.framework.model.SysDept;
import com.zmm.framework.model.SysRole;
import com.zmm.framework.model.SysRoleMenu;
import com.zmm.framework.model.SysUserRole;
import com.zmm.framework.service.SysAuthorizeService;
import com.zmm.framework.service.SysDeptService;
import com.zmm.framework.service.SysRoleService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.transaction.annotation.Transactional;
import top.ibase4j.core.base.BaseServiceImpl;
import top.ibase4j.core.support.Pagination;

import java.util.List;
import java.util.Map;

/**
 * @Name SysRoleServiceImpl
 * @Author 900045
 * @Created by 2019/7/6 0006
 */
@CacheConfig(cacheNames = "sysRole")
@Service(interfaceClass = SysRoleService.class)
public class SysRoleServiceImpl extends BaseServiceImpl<SysRole, SysRoleMapper> implements SysRoleService {
	@Autowired
	private SysDeptService sysDeptService;
	@Autowired
	private SysAuthorizeService sysAuthorizeService;
	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;
	@Autowired
	private SysRoleMenuMapper sysRoleMenuMapper;

	@Override
	public SysRole queryById(Long id) {
		SysRole sysRole = super.queryById(id);
		if (sysRole != null) {
			if (sysRole.getDeptId() != null && sysRole.getDeptId() != 0) {
				SysDept sysDept = sysDeptService.queryById(sysRole.getDeptId());
				if (sysDept != null) {
					sysRole.setDeptName(sysDept.getDeptName());
				} else {
					sysRole.setDeptId(null);
				}
			}
		}
		return sysRole;
	}

	@Override
	public Pagination<SysRole> query(Map<String, Object> params) {
		Pagination<SysRole> pageInfo = super.query(params);
		// 权限信息
		for (SysRole bean : pageInfo.getRecords()) {
			if (bean.getDeptId() != null && bean.getDeptId() != 0) {
				SysDept sysDept = sysDeptService.queryById(bean.getDeptId());
				if (sysDept != null) {
					bean.setDeptName(sysDept.getDeptName());
				}
			}
			List<String> permissions = sysAuthorizeService.queryRolePermission(bean.getId());
			for (String permission : permissions) {
				if (StringUtils.isBlank(bean.getPermission())) {
					bean.setPermission(permission);
				} else {
					bean.setPermission(bean.getPermission() + ";" + permission);
				}
			}
		}
		return pageInfo;
	}

	@Override
	@Transactional
	public void delete(Long id) {
		super.delete(id);
		sysUserRoleMapper.delete(new UpdateWrapper<SysUserRole>(new SysUserRole().setRoleId(id)));
		sysRoleMenuMapper.delete(new UpdateWrapper<SysRoleMenu>(new SysRoleMenu().setMenuId(id)));
	}
}

