package com.zmm.framework.enums;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *  返回状态码枚举----公共用
 * @Name ResultCode
 * @Author 900045
 * @Created by 2019/7/6 0006
 */
public enum ResultCode implements RespCode {
	RESPONSE_SUCCESS(200,"前端返回成功"),
	SUCCESS(1000, "成功"),
	FIELD(9000, "操作失败!"),


	;
	// ========================成员变量

	/**
	 * 编码
	 */
	private int code;
	/**
	 * 中文描述
	 */
	private String desc;
	/**
	 * 英文描述
	 */
	private String enDesc;

	/**
	 * 返回码MAP
	 */
	private static Map<Integer, RespCode> map;

	static {
		// 初始化
		map = new HashMap<>();
		for (ResultCode code : ResultCode.values()) {
			map.put(code.getCode(), code);
		}

		for (RespOrderCode code : RespOrderCode.values()) {
			map.put(code.getCode(), code);
		}

	}

	private ResultCode(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	private ResultCode(int code, String desc, String enDesc) {
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
	 * @param
	 * @return
	 */
	public static String getDesc(int code) {
		RespCode respCode = map.get(code);
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
