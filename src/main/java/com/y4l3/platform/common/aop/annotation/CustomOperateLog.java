package com.y4l3.platform.common.aop.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.y4l3.platform.common.aop.assist.OperateType;

/**
 * 自定义日志方法注解
 * @author changzhongq
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CustomOperateLog {
	OperateType type();
}
