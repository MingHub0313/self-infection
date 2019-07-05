package com.zmm.framework.service;

import com.zmm.framework.model.SysSession;
import top.ibase4j.core.base.BaseService;

import java.util.List;

/**
 * @Name SysSessionService
 * @Author 900045
 * @Created by 2019/7/5 0005
 */
public interface SysSessionService extends BaseService<SysSession> {

	/**
	 * 删除 Session
	 * @param sysSession
	 */
	void deleteBySessionId(final SysSession sysSession);

	/**
	 *查询 Session
	 * @param sysSession
	 * @return
	 */
	List<String> querySessionIdByAccount(SysSession sysSession);

	/**
	 * 清除
	 */
	void cleanExpiredSessions();
}
