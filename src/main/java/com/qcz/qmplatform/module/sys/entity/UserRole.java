package com.qcz.qmplatform.module.sys.entity;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户-角色对应 实体
 * @author changzhongq
 */
@Data
@Table(name = "sys_user_role")
public class UserRole implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String userRoleId;
	
	private String roleId;
	
	private String userId;
	
}
