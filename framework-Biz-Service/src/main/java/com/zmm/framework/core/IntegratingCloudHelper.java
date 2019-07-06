package com.zmm.framework.core;

import com.zmm.framework.enums.CommonKeys;
import com.zmm.framework.enums.ResultCode;
import com.zmm.framework.service.SysParamService;
import io.rong.RongCloud;
import io.rong.models.Result;
import io.rong.models.message.PrivateMessage;
import io.rong.models.response.ResponseResult;
import io.rong.models.response.TokenResult;
import io.rong.models.user.UserModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Service;
import top.ibase4j.core.exception.BusinessException;
import top.ibase4j.core.support.context.ApplicationContextHolder;

/**
 * @Name IntegratingCloudHelper
 * @Author 900045
 * @Created by 2019/7/6 0006
 */
@Service
@ConditionalOnClass(RongCloud.class)
public final class IntegratingCloudHelper implements InitializingBean {

	private static Logger logger = LogManager.getLogger();
	private static RongCloud rongCloud;

	@Override
	public void afterPropertiesSet() throws Exception {
		getInstance();
	}
	/** 获取融云客户端*/
	public static RongCloud getInstance() {
		if (rongCloud == null) {
			synchronized (logger) {
				if (rongCloud == null) {
					SysParamService sysParamService = ApplicationContextHolder.getService(SysParamService.class);
					rongCloud = RongCloud.getInstance(sysParamService.getValue(CommonKeys.RONG_CLOUD_APP_KEY.getName()),
							sysParamService.getValue(CommonKeys.RONG_CLOUD_SECRET.getName()));
				}
			}
		}
		return rongCloud;
	}

	/** 注册用户 */
	public static String regin(UserModel userModel) {
		try {
			TokenResult tokenResult = getInstance().user.register(userModel);
			logger.info("getToken:  " + tokenResult.toString());
			if (tokenResult.getCode() == ResultCode.RESPONSE_SUCCESS.getCode()) {
				return tokenResult.getToken();
			} else {
				throw new BusinessException(tokenResult.getErrorMessage());
			}
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	/** 修改用户信息 */
	public static void update(UserModel userModel) {
		try {
			Result result = getInstance().user.update(userModel);
			logger.info("update user:  " + result.toString());
			if (result.getCode() != ResultCode.RESPONSE_SUCCESS.getCode()) {
				throw new BusinessException(result.getErrorMessage());
			}
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	/** 发送消息 */
	public static void sendPrivateMsg(PrivateMessage privateMessage) {
		try {
			ResponseResult result = getInstance().message.msgPrivate.send(privateMessage);
			logger.info("send private message:  " + result.toString());
			if (result.getCode() != ResultCode.RESPONSE_SUCCESS.getCode()) {
				throw new BusinessException(result.getErrorMessage());
			}
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}
}
