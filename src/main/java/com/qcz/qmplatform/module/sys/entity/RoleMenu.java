package com.qcz.qmplatform.module.sys.entity;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 角色菜单 实体
 * @author changzhongq
 * @time 2018年6月19日 上午11:20:58
 */
@Data
@Table(name = "sys_role_menu")
public class RoleMenu implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String roleMenuId;
	
	private String roleId;
	
	private String menuId;
	
}
