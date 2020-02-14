package com.y4l3.platform.module.sys.form;

import lombok.Data;

/**
 * 角色表单
 * @author changzhongq
 * @time 2018年12月1日 下午6:45:38
 */
@Data
public class RoleForm {
	
	public String roleId;

	public String roleName;

	public String roleSign;

	public String remark;
	
	public String userId;
	
	public int checked;
}
