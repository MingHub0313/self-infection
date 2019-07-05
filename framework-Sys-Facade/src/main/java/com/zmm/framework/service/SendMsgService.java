package com.zmm.framework.service;

import com.zmm.framework.model.SendMsg;

/**
 * @Name SendMsgService
 * @Author 900045
 * @Created by 2019/7/5 0005
 */
public interface SendMsgService {

	/**
	 * 发送短信验证码
	 * @param sendMsg
	 */
	void sendMsg(SendMsg sendMsg);

	/**
	 * 发送语音验证码
	 * @param sendMsg
	 */
	void sendTts(SendMsg sendMsg);
}
