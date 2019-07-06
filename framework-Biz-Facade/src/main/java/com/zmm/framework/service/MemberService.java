package com.zmm.framework.service;

import com.zmm.framework.bean.Member;
import com.zmm.framework.model.TmEmber;
import top.ibase4j.core.base.BaseService;

import java.util.Map;

/**
 * 业务服务接口
 * @Name MemberService
 * @Author 900045
 * @Created by 2019/7/5 0005
 */
public interface MemberService extends BaseService<TmEmber> {

	/**
	 * 根据 id 获取基本信息
	 * @param id
	 * @return
	 */
	Member getBaseInfo(Long id);


	/**
	 * 根据 id 获取会员信息
	 * @param id
	 * @return
	 */
	TmEmber getInfo(Long id);


	/**
	 * 更换手机号
	 * @param map
	 * @return
	 */
	Object updatePhone(Map<String, Object> map);


	/**
	 * 实名认证
	 * @param map
	 * @return
	 */
	Object authentication(Map<String, Object> map);

}
