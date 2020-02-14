package com.y4l3.platform.module.sys.entity;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 图标
 * @author changzhongq
 * @time 2018年11月18日 下午7:24:51
 */
@Data
@Table(name = "sys_icon")
public class Icon implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@Id
	private String iconId;
	
	/**
	 * 图标编码
	 */
	private String iconCode;
	
	/**
	 * 图标名称
	 */
	private String iconName;
	
	/**
	 * 图标字体类
	 */
	private String iconFontClass;

}
