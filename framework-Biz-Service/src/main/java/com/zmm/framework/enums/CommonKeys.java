package com.zmm.framework.enums;

/**
 * @Name CommonKeys
 * @Author 900045
 * @Created by 2019/7/6 0006
 */
public enum CommonKeys {

	/**
	 * 融云 appkey
	 */
	RONG_CLOUD_APP_KEY("RONGCLOUD_APPKEY"),
	/**
	 * 融云 密钥
	 */
	RONG_CLOUD_SECRET("RONGCLOUD_SECRET"),
	;

	public String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	CommonKeys(String name) {
		this.name = name;
	}

}
