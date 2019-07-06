package com.zmm.framework.service.impl;

import com.zmm.framework.mapper.SysEventMapper;
import com.zmm.framework.model.SysUser;
import com.zmm.framework.service.SysUserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import top.ibase4j.core.base.BaseServiceImpl;
import top.ibase4j.core.support.Pagination;
import top.ibase4j.model.SysEvent;
import top.ibase4j.service.SysEventService;

import java.util.Map;

/**
 * @Name SysEventServiceImpl
 * @Author 900045
 * @Created by 2019/7/6 0006
 */
@CacheConfig(cacheNames = "sysEvent")
@Service(interfaceClass = SysEventService.class)
public class SysEventServiceImpl extends BaseServiceImpl<SysEvent, SysEventMapper> implements SysEventService {
	@Autowired
	private SysUserService sysUserService;

	@Override
	public Pagination<SysEvent> query(Map<String, Object> params) {
		Pagination<SysEvent> page = super.query(params);
		for (SysEvent sysEvent : page.getRecords()) {
			if (sysEvent != null) {
				Long createBy = sysEvent.getCreateBy();
				if (createBy != null) {
					SysUser sysUser = sysUserService.queryById(createBy);
					if (sysUser != null) {
						sysEvent.setUserName(sysUser.getUserName());
					} else {
						sysEvent.setUserName(createBy.toString());
					}
				}
			}
		}
		return page;
	}
}

