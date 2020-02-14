package com.y4l3.platform.common.message;

import lombok.Data;

import java.io.Serializable;

/**
 * 分页请求参数（layui风格）
 * @author changzhongq
 * @time 2018年6月12日 上午9:56:55
 */
@Data
public class PageRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 页数
	 */
	private Integer page;
	
	/**
	 * 每页记录数
	 */
	private Integer limit;
	
	/**
	 * 排序字段
	 */
	private String field;
	
	/**
	 * 排序方式
	 */
	private String order;

	public PageRequest() {

	}

	public PageRequest(Integer page, Integer limit, String field, String order) {
		this.page = page;
		this.limit = limit;
		this.field = field;
		this.order = order;
	}

}
