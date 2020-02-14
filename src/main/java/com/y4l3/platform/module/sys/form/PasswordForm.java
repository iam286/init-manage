package com.y4l3.platform.module.sys.form;

import lombok.Data;

/**
 * 密码表单 用于安全设置
 * @author changzhongq
 * @time 2018年12月15日 下午2:58:51
 */
@Data
public class PasswordForm {

	/**
	 * 原密码
	 */
	public String oldLoginPassword;
	
	/**
	 * 新密码
	 */
	public String loginPassword;
	
}
