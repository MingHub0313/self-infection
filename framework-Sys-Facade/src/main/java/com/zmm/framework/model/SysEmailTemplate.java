package com.zmm.framework.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import top.ibase4j.core.base.BaseModel;

import java.io.Serializable;

/**
 * <p>邮件模版表</p>
 * @Name SysEmailTemplate
 * @Author 900045
 * @Created by 2019/7/5 0005
 */
@TableName("sys_email_template")
public class SysEmailTemplate extends BaseModel {

	/**
	 * 邮件名称
	 */
	@TableField(value = "sender_name")
	private String senderName;
	/**
	 * 发送邮件帐号
	 */
	@TableField(value = " sender_account")
	private String senderAccount;
	/**
	 * 排序号
	 */
	@TableField(value = "sort_")
	private Integer sort;
	/**
	 * 标题模版
	 */
	@TableField(value = "title_")
	private String title;
	/**
	 * 内容模板
	 */
	@TableField(value = "template_")
	private String template;

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSenderAccount() {
		return senderAccount;
	}

	public void setSenderAccount(String senderAccount) {
		this.senderAccount = senderAccount;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	protected Serializable pkVal() {
		return getId();
	}
}