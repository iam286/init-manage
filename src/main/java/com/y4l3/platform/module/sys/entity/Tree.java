package com.y4l3.platform.module.sys.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 树
 * @author changzhongq
 * @time 2018年6月16日 下午9:00:00
 */
@Data
public class Tree implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	
	private String name;
	
	private String parentId;
	
	private String parentName;
	
	private List<Tree> childrens;
	
	private boolean hasParent;
	
	private boolean hasChild;

	private String icon;
	
	private String url;

}
