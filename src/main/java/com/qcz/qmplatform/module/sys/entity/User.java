package com.qcz.qmplatform.module.sys.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户 实体
 * @author changzhongq
 * @time 2018年6月10日 上午10:58:28
 */
@Data
@Table(name = "sys_user")
public class User implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
	@Id
	private String userId;

	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * 登录名
	 */
	private String loginName;

	/**
	 * 登录密码
	 */
	private String loginPassword;

	/**
	 * 性别
	 */
	private String userSex;

	/**
	 * 锁定状态（0：锁定，1：正常）
	 */
	private String locked;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 创建人ID
	 */
	private String createUserId;

	/**
	 * 创建人名称
	 */
	private String createUserName;

	/**
	 * 修改人ID
	 */
	private String updateUserId;

	/**
	 * 修改人名称
	 */
	private String updateUserName;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 更新时间
	 */
	private Date updateTime;

	/**
	 * 用户图片
	 */
	private String userImage;

	/**
	 * 用户主题
	 */
	public String themeColor;

	public User() {
	}

	public User(String loginName, String loginPassword) {
		this.loginName = loginName;
		this.loginPassword = loginPassword;
	}
	
	public User(String loginName) {
		this.loginName = loginName;
	}
	
	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}

}
