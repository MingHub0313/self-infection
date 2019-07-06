package com.zmm.framework.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import top.ibase4j.core.base.BaseModel;

/**
 * <p>邮件配置表</p>
 * @Name SysEmailConfig
 * @Author 900045
 * @Created by 2019/7/5 0005
 */
@TableName("sys_email_config")
public class SysEmailConfig extends BaseModel {

	/**
	 * SMT服务器
	 * todo smtp_host--->smt_host
	 */
	@TableField(value = "smt_host")
	private String smtHost;
	/** SMT服务器端口
	 * todo smtp_port --->smt_port
	 */
	@TableField(value = "smt_port")
	private String smtPort;
	/**
	 * 名称
	 */
	@TableField(value = "sender_name")
	private String senderName;
	/**
	 * 发邮件邮箱账号
	 */
	@TableField(value = "sender_account")
	private String senderAccount;
	/**
	 * 发邮件邮箱密码
	 */
	@TableField(value = "sender_password")
	private String senderPassword;
	/**
	 * 发送邮箱鉴权
	 */
	@TableField(value = "sender_password_auth")
	private String senderPasswordAuth;
	/**
	 * 发送邮箱方式
	 */
	@TableField(value = "is_ssl")
	private Boolean isSSL;

	public String getSmtHost() {
		return smtHost;
	}

	public void setSmtHost(String smtHost) {
		this.smtHost = smtHost;
	}

	public String getSmtPort() {
		return smtPort;
	}

	public void setSmtPort(String smtPort) {
		this.smtPort = smtPort;
	}

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

	public String getSenderPassword() {
		return senderPassword;
	}

	public void setSenderPassword(String senderPassword) {
		this.senderPassword = senderPassword;
	}

	public String getSenderPasswordAuth() {
		return senderPasswordAuth;
	}

	public void setSenderPasswordAuth(String senderPasswordAuth) {
		this.senderPasswordAuth = senderPasswordAuth;
	}

	public Boolean getIsSSL() {
		return isSSL;
	}

	public void setIsSSL(Boolean isSSL) {
		this.isSSL = isSSL;
	}
}
