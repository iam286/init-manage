package com.y4l3.platform.module.sys.entity;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.Id;

/**
 * 系统会话管理
 * @author changzhongq
 * @time 2019年3月14日 上午10:19:47
 */
@Data
public class SysSession implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String sessionId;
	
	private byte[] session;

}
