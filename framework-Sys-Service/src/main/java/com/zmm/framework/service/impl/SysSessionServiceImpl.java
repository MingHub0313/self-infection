package com.zmm.framework.service.impl;

import com.zmm.framework.mapper.SysSessionMapper;
import com.zmm.framework.model.SysSession;
import com.zmm.framework.service.SysSessionService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.transaction.annotation.Transactional;
import top.ibase4j.core.Constants;
import top.ibase4j.core.base.BaseServiceImpl;
import top.ibase4j.core.util.CacheUtil;
import top.ibase4j.core.util.InstanceUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Name SysSessionServiceImpl
 * @Author 900045
 * @Created by 2019/7/6 0006
 */
@CacheConfig(cacheNames = "sysSession")
@Service(interfaceClass = SysSessionService.class)
public class SysSessionServiceImpl extends BaseServiceImpl<SysSession, SysSessionMapper> implements SysSessionService {


	@Override
	@CachePut
	@Transactional
	/**
	 * 更新
	 * @param record
	 * @return
	 */
	public SysSession update(SysSession record) {
		if (record != null && record.getId() == null) {
			record.setUpdateTime(new Date());
			Long id = mapper.queryBySessionId(record.getSessionId());
			if (id != null) {
				mapper.updateById(record);
			} else {
				record.setCreateTime(new Date());
				mapper.insert(record);
			}
		} else {
			mapper.updateById(record);
		}
		return record;
	}

	/**
	 * 系统触发,由系统自动管理缓存
	 * @param sysSession
	 */
	@Override
	public void deleteBySessionId(final SysSession sysSession) {
		if (sysSession != null) {
			mapper.deleteBySessionId(sysSession.getSessionId());
		}
	}

	@Override
	public List<String> querySessionIdByAccount(SysSession sysSession) {
		if (sysSession != null) {
			return mapper.querySessionIdByAccount(sysSession.getAccount());
		}
		return null;
	}

	@Override
	public void cleanExpiredSessions() {
		Map<String, Object> columnMap = InstanceUtil.newHashMap();
		List<SysSession> sessions = queryList(columnMap);
		for (SysSession sysSession : sessions) {
			if (sysSession != null) {
				logger.info("检查SESSION : {}", sysSession.getSessionId());
				if (!CacheUtil.getCache().exists(Constants.REDIS_SHIRO_SESSION + sysSession.getSessionId())) {
					logger.info("移除SESSION : {}", sysSession.getSessionId());
					delete(sysSession.getId());
				}
			}
		}
	}
}

