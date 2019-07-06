package com.zmm.framework.service.impl;

import com.zmm.framework.bean.Member;
import com.zmm.framework.mapper.TmEmberMapper;
import com.zmm.framework.model.TmEmber;
import com.zmm.framework.service.MemberService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.cache.annotation.CacheConfig;
import top.ibase4j.core.base.BaseServiceImpl;
import top.ibase4j.core.util.InstanceUtil;

import java.util.Map;

/**
 *<p>会员 服务实现类</p>
 * @Name MemberServiceImpl
 * @Author 900045
 * @Created by 2019/7/6 0006
 */
@CacheConfig(cacheNames = "member")
@Service(interfaceClass = MemberService.class)
public class MemberServiceImpl extends BaseServiceImpl<TmEmber, TmEmberMapper> implements MemberService {

	@Override
	public Member getBaseInfo(Long id) {
		TmEmber tmEmber=super.queryById(id);
		Member result = null;
		if (tmEmber != null) {
			//对象之间的转换
			result = InstanceUtil.to(tmEmber, Member.class);
		}
		return result;
	}

	@Override
	public TmEmber getInfo(Long id) {
		TmEmber tmEmber = super.queryById(id);
		if (tmEmber != null) {
			tmEmber.setPassword(null);
			tmEmber.setUuid(null);
		}
		return tmEmber;
	}

	@Override
	public Object updatePhone(Map<String, Object> map) {
		TmEmber member1 = new TmEmber();
		member1.setIdCard((String)map.get("idCard"));
		member1.setPhone((String)map.get("orderPhone"));
		member1.setRealName((String)map.get("realName"));
		TmEmber member2 = super.selectOne(member1);
		if (member2.getId() == null) {
			return "请输入正确的信息 ";
		} else {
			member2.setPhone((String)map.get("newPhone"));
			return super.update(member2);
		}
	}

	@Override
	public Object authentication(Map<String, Object> map) {
		// 实名认证
		TmEmber tmEmber = new TmEmber();
		tmEmber.setId(Long.parseLong((String)map.get("memberId")));
		TmEmber selectOne = super.selectOne(tmEmber);
		selectOne.setRealName((String)map.get("realName"));
		selectOne.setIdCard((String)map.get("idCard"));
		return super.update(selectOne);
	}
}
