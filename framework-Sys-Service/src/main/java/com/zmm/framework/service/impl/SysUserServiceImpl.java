package com.zmm.framework.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zmm.framework.mapper.SysUserMapper;
import com.zmm.framework.mapper.SysUserRoleMapper;
import com.zmm.framework.mapper.SysUserThirdPartyMapper;
import com.zmm.framework.model.SysDept;
import com.zmm.framework.model.SysUser;
import com.zmm.framework.model.SysUserRole;
import com.zmm.framework.model.SysUserThirdParty;
import com.zmm.framework.service.SysAuthorizeService;
import com.zmm.framework.service.SysDeptService;
import com.zmm.framework.service.SysDicService;
import com.zmm.framework.service.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;
import top.ibase4j.core.base.BaseServiceImpl;
import top.ibase4j.core.exception.BusinessException;
import top.ibase4j.core.support.Pagination;
import top.ibase4j.core.support.login.ThirdPartyUser;
import top.ibase4j.core.util.DataUtil;
import top.ibase4j.core.util.InstanceUtil;
import top.ibase4j.core.util.SecurityUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Name SysUserServiceImpl
 * @Author 900045
 * @Created by 2019/7/6 0006
 */
@CacheConfig(cacheNames = "sysUser")
@Service(interfaceClass = SysUserService.class)
public class SysUserServiceImpl extends BaseServiceImpl<SysUser, SysUserMapper> implements SysUserService {
	@Autowired
	private SysUserThirdPartyMapper thirdPartyMapper;
	@Autowired
	private SysDicService sysDicService;
	@Autowired
	private SysDeptService sysDeptService;
	@Autowired
	private SysAuthorizeService sysAuthorizeService;
	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;

	@Override
	@Transactional
	public SysUser update(SysUser record) {
		if (DataUtil.isNotEmpty(record.getOldPassword())) {
			SysUser sysUser = super.queryById(record.getId());
			String encryptPassword = SecurityUtil.encryptPassword(record.getOldPassword());
			if (!sysUser.getPassword().equals(encryptPassword)) {
				throw new BusinessException("原密码错误.");
			}
		}
		if (DataUtil.isEmpty(record.getPassword())) {
			record.setPassword(null);
		} else {
			record.setPassword(SecurityUtil.encryptPassword(record.getPassword()));
		}
		return super.update(record);
	}

	@Override
	public SysUser queryById(Long id) {
		SysUser record = super.queryById(id);
		if (record.getDeptId() != null) {
			SysDept sysDept = sysDeptService.queryById(record.getDeptId());
			if (sysDept != null) {
				record.setDeptName(sysDept.getDeptName());
			} else {
				record.setDeptId(null);
			}
		}
		return record;
	}

	@Override
	public Pagination<SysUser> query(Map<String, Object> params) {
		Map<String, String> userTypeMap = sysDicService.queryDicByType("USERTYPE");
		Pagination<SysUser> pageInfo = super.query(params);
		for (SysUser userBean : pageInfo.getRecords()) {
			if (userBean.getDeptId() != null) {
				SysDept sysDept = sysDeptService.queryById(userBean.getDeptId());
				if (sysDept != null) {
					userBean.setDeptName(sysDept.getDeptName());
				} else {
					userBean.setDeptId(null);
				}
			}
			if (userBean.getUserType() != null) {
				userBean.setUserTypeText(userTypeMap.get(userBean.getUserType()));
			}
			List<String> permissions = sysAuthorizeService.queryUserPermission(userBean.getId());
			for (String permission : permissions) {
				if (StringUtils.isBlank(userBean.getPermission())) {
					userBean.setPermission(permission);
				} else {
					userBean.setPermission(userBean.getPermission() + ";" + permission);
				}
			}
		}
		return pageInfo;
	}

	@Override
	@Transactional
	public void delete(Long id) {
		super.delete(id);
		sysUserRoleMapper.delete(new UpdateWrapper<SysUserRole>(new SysUserRole().setUserId(id)));
	}

	/** 查询第三方帐号用户Id */
	@Override
	@Cacheable
	public Long queryUserIdByThirdParty(ThirdPartyUser param) {
		return thirdPartyMapper.queryUserIdByThirdParty(param.getProvider(), param.getOpenid());
	}

	/** 保存第三方帐号 */
	@Override
	@Transactional
	public SysUser insertThirdPartyUser(ThirdPartyUser thirdPartyUser) {
		SysUser sysUser = new SysUser();
		sysUser.setSex(0);
		sysUser.setUserType("1");
		sysUser.setPassword(SecurityUtil.encryptPassword("123456"));
		sysUser.setUserName(thirdPartyUser.getUserName());
		sysUser.setAvatar(thirdPartyUser.getAvatarUrl());
		// 初始化第三方信息
		SysUserThirdParty thirdParty = new SysUserThirdParty();
		thirdParty.setProvider(thirdPartyUser.getProvider());
		thirdParty.setOpenId(thirdPartyUser.getOpenid());
		thirdParty.setCreateTime(new Date());

		this.update(sysUser);
		sysUser.setAccount(thirdParty.getProvider() + sysUser.getId());
		this.update(sysUser);
		thirdParty.setUserId(sysUser.getId());
		thirdPartyMapper.insert(thirdParty);
		return sysUser;
	}

	@Override
	public void init() {
		queryList(InstanceUtil.newHashMap());
	}
}

