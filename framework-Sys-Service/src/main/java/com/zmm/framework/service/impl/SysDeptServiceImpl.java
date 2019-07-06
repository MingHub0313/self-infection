package com.zmm.framework.service.impl;

import com.zmm.framework.mapper.SysDeptMapper;
import com.zmm.framework.model.SysDept;
import com.zmm.framework.service.SysDeptService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.cache.annotation.CacheConfig;
import top.ibase4j.core.base.BaseServiceImpl;

import java.util.List;
import java.util.Map;

/**
 * @Name SysDeptServiceImpl
 * @Author 900045
 * @Created by 2019/7/6 0006
 */
@CacheConfig(cacheNames = "sysDept")
@Service(interfaceClass = SysDeptService.class)
public class SysDeptServiceImpl extends BaseServiceImpl<SysDept, SysDeptMapper> implements SysDeptService {
	@Override
	public List<SysDept> queryList(Map<String, Object> params) {
		List<SysDept> page = super.queryList(params);
		for (SysDept sysDept : page) {
			if (sysDept != null) {
				if (sysDept.getParentId() != null) {
					SysDept parent = super.queryById(sysDept.getParentId());
					if (parent != null) {
						sysDept.setParentName(parent.getDeptName());
					} else {
						sysDept.setParentId(null);
					}
				}
			}
		}
		return page;
	}
}
