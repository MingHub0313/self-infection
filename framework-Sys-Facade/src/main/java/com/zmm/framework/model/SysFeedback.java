package com.zmm.framework.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import top.ibase4j.core.base.BaseModel;

/**
 * <p>反馈</p>
 * @Name SysFeedback
 * @Author 900045
 * @Created by 2019/7/5 0005
 */
@TableName("sys_feedback")
public class SysFeedback extends BaseModel {

	private static final long serialVersionUID = 1L;

	/**
	 * 类型
	 */
	@TableField("type_")
	private String type;
	/**
	 * 用户名
	 */
	@TableField("user_name")
	private String userName;
	/**
	 * 内容
	 */
	@TableField("content_")
	private String content;
	/**
	 * 来源
	 */
	@TableField("resource_")
	private String resource;


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}
}
