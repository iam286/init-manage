package com.y4l3.platform.common.message;

import lombok.Data;

/**
 * 响应结果统一处理
 * @author quchangzhong
 * @time 2018年1月19日 下午8:17:30
 */
@Data
public class ResponseResult {

	private boolean success;

	private String msg;

	private Object data;

	public ResponseResult(boolean success, String msg, Object data) {
		super();
		this.success = success;
		this.msg = msg;
		this.data = data;
	}

	public ResponseResult() {
	}

	public static ResponseResult ok(String msg, Object data) {
		return new ResponseResult(true, msg, data);
	}

	public static ResponseResult ok(Object data) {
		return new ResponseResult(true, null, data);
	}
	
	public static ResponseResult ok() {
		return new ResponseResult(true, null, null);
	}

	public static ResponseResult error(String msg) {
		return new ResponseResult(false, msg, null);
	}

}
