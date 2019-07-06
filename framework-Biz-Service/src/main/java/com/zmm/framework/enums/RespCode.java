package com.zmm.framework.enums;

/**
 * 通用返回码定义
 * @Name RespCode
 * @Author 900045
 * @Created by 2019/7/6 0006
 */
public interface RespCode {

	/**
	 * 获取返回码
	 *
	 * @return
	 */
	int getCode();


	/**
	 * 获取返回描述
	 *
	 * @return
	 */
	String getDesc();

	String getEnDesc();
}
