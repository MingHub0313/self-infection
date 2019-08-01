package com.zmm.framework.mapper;

import com.zmm.framework.model.SysSession;
import top.ibase4j.core.base.BaseMapper;

import java.util.List;

/**
 * @Name SysSessionMapper
 * @Author 900045
 * @Created by 2019/7/6 0006
 */
public interface SysSessionMapper extends BaseMapper<SysSession>  {


	/**
	 * 根据 SessionId 删除
	 * @param sessionId
	 */
	void deleteBySessionId(String sessionId);

	/**
	 * 根据 Sessionid 查询
	 * @param sessionId
	 * @return
	 */
	Long queryBySessionId(String sessionId);

	/**
	 * 根据账号 查询 Session
	 * @param account
	 * @return
	 */
	List<String> querySessionIdByAccount(String account);
}
