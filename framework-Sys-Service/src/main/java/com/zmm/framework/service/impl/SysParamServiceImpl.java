package com.zmm.framework.service.impl;

import com.zmm.framework.mapper.SysParamMapper;
import com.zmm.framework.model.SysParam;
import com.zmm.framework.service.SysParamService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import top.ibase4j.core.Constants;
import top.ibase4j.core.base.BaseServiceImpl;
import top.ibase4j.core.support.context.ApplicationContextHolder;
import top.ibase4j.core.util.InstanceUtil;

import java.util.List;
import java.util.Map;

/**
 * @Name SysParamServiceImpl
 * @Author 900045
 * @Created by 2019/7/6 0006
 */
@CacheConfig(cacheNames = "sysParam")
@Service(interfaceClass = SysParamService.class)
public class SysParamServiceImpl extends BaseServiceImpl<SysParam, SysParamMapper> implements SysParamService {
	@Override
	@Cacheable(value = Constants.CACHE_NAMESPACE + "sysParams")
	public Map<String, String> getAllParams() {
		Map<String, Object> params = InstanceUtil.newHashMap();
		params.put("orderBy", "type_,sort_no");
		List<SysParam> list = queryList(params);
		Map<String, String> resultMap = InstanceUtil.newHashMap();
		for (SysParam sysParam : list) {
			if (sysParam != null) {
				resultMap.put(sysParam.getParamKey(), sysParam.getParamValue());
			}
		}
		return resultMap;
	}

	@Override
	@Cacheable(value = Constants.CACHE_NAMESPACE + "sysParamName")
	public String getName(String key) {
		if (StringUtils.isBlank(key)) {
			return "";
		}
		Map<String, Object> params = InstanceUtil.newHashMap();
		params.put("orderBy", "type_,sort_no");
		List<SysParam> list = queryList(params);
		for (SysParam sysParam : list) {
			if (sysParam != null) {
				if (key.equals(sysParam.getParamKey())) {
					return sysParam.getRemark();
				}
			}
		}
		return "";
	}

	@Override
	public String getValue(String key) {
		return getValue(key, "");
	}

	@Override
	public String getValue(String key, String defaultValue) {
		String value = ApplicationContextHolder.getBean(SysParamService.class).getAllParams().get(key);
		if (StringUtils.isBlank(value)) {
			return defaultValue;
		}
		return value;
	}
}

