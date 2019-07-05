package com.zmm.framework.service;

import com.zmm.framework.model.SysUser;
import top.ibase4j.core.base.BaseService;
import top.ibase4j.core.support.login.ThirdPartyUser;

/**
 * @Name SysUserService
 * @Author 900045
 * @Created by 2019/7/5 0005
 */
public interface SysUserService extends BaseService<SysUser> {

	/**
	 * 查询第三方帐号用户Id
	 * @param param
	 * @return
	 */
	Long queryUserIdByThirdParty(ThirdPartyUser param);

	/**
	 * 保存第三方帐号
	 * @param thirdPartyUser
	 * @return
	 */
	SysUser insertThirdPartyUser(ThirdPartyUser thirdPartyUser);

	/**
	 * 加载所有用户信息
	 */
	void init();
}
