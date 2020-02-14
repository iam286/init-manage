package com.y4l3.platform.common.base;

import org.apache.ibatis.annotations.Param;

import com.y4l3.platform.module.common.Field;

import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 
 * @author changzhongq
 * @time 2018年11月17日 下午10:39:02
 */
public interface BaseDao<T> extends Mapper<T> {
	int batchInsert(@Param("table") String table, @Param("cloumns") String cloumns, @Param("list") List<List<Object>> list);

	int batchDelete(@Param("table") String table, @Param("idCloumn") String idCloumn, @Param("ids") Object[] ids);
	
	int updateByIdWithMap(@Param("table") String table, @Param("idCloumn") Object idCloumn, @Param("idValue") Object idValue, @Param("fields") List<Field> fields);
	
	int updateByIdWithField(@Param("table") String table, @Param("idCloumn") Object idCloumn, @Param("idValue") Object idValue, @Param("fieldName") String fieldName, @Param("fieldValue") Object fieldValue);
}
