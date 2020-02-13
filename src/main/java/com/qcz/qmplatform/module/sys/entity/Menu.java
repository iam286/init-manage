package com.qcz.qmplatform.module.sys.entity;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 菜单 实体类
 * @author changzhongq
 * @time 2018年6月11日 下午5:30:17
 */
@Data
@Table(name = "sys_menu")
public class Menu implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 菜单ID
	 */
	@Id
	private String menuId;
	
	/**
	 * 菜单名称
	 */
	private String menuName;
	
	/**
	 * 父菜单ID
	 */
	private String parentId;
	
	/**
	 * 父菜单名称
	 */
	private String parentName;
	
	/**
	 * 请求路径
	 */
	private String url;
	
	/**
	 * 菜单图标（layui图标）
	 */
	private String icon;
	
	/**
	 * 排序
	 */
	private Integer sort;

}
