package com.zmm.framework.enums;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *  返回状态码枚举 ----- 订单用
 * @Name RespOrderCode
 * @Author 900045
 * @Created by 2019/7/6 0006
 */
public enum RespOrderCode implements RespCode {

	;

	// ===========================成员变量

	/**
	 * 编码
	 */
	private int                         code;

	/**
	 *  中文描述
	 */
	private String                      desc;

	/**
	 * 英文描述
	 */
	private String                      enDesc;

	/**
	 * 返回码MAP
	 */
	private static Map<Integer, RespOrderCode> map;

	static {
		//初始化
		map = new HashMap<>(values().length);
		for (RespOrderCode respCode : RespOrderCode.values()) {
			map.put(respCode.getCode(), respCode);
		}
	}

	private RespOrderCode(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	private RespOrderCode(int code, String desc, String enDesc) {
		this.code = code;
		this.desc = desc;
		this.enDesc = enDesc;
	}

	public static RespCode getType(int code) {
		if (code <= 0) {
			return null;
		}
		return map.get(code);
	}

	@Override
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	@Override
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * 获取返回码反描述
	 *
	 * @param index
	 * @return
	 */
	public static String getDesc(int code) {
		RespCode respCode = getType(code);
		return respCode == null ? "" : respCode.getDesc();
	}

	@Override
	public String getEnDesc() {
		return enDesc;
	}

	public void setEnDesc(String enDesc) {
		this.enDesc = enDesc;
	}
}
