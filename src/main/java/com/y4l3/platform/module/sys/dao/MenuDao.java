package com.y4l3.platform.module.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.y4l3.platform.common.base.BaseDao;
import com.y4l3.platform.module.sys.entity.Menu;
import com.y4l3.platform.module.sys.entity.Tree;

/**
 * 菜单 Mapper
 * @author changzhongq
 * @time 2018年6月15日 下午10:02:21
 */
public interface MenuDao extends BaseDao<Menu> {

	List<Tree> menuTreesData(@Param("userId") String userId);

	List<Map<String, Object>> menuList();

	List<Map<String, Object>> getMenuTreeWithStatus(String roleId);

}
