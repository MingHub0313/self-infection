package com.zmm.framework.mapper;

import com.zmm.framework.model.SysUserThirdParty;
import org.apache.ibatis.annotations.Param;
import top.ibase4j.core.base.BaseMapper;

/**
 * @Name SysUserThirdPartyMapper
 * @Author 900045
 * @Created by 2019/7/6 0006
 */
public interface SysUserThirdPartyMapper extends BaseMapper<SysUserThirdParty> {


	/**
	 * 根据 供应商 和 openId 查询用户Id
	 * @param provider
	 * @param openId
	 * @return
	 */
	Long queryUserIdByThirdParty(@Param("provider") String provider, @Param("openId") String openId);
}
