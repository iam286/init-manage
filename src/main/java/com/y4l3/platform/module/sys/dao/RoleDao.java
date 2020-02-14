package com.y4l3.platform.module.sys.dao;

import java.util.List;
import java.util.Map;

import com.y4l3.platform.common.base.BaseDao;
import com.y4l3.platform.module.sys.entity.Role;
import com.y4l3.platform.module.sys.form.RoleForm;

/**
 * 角色 数据层
 * @author changzhongq
 */
public interface RoleDao extends BaseDao<Role> {

	List<RoleForm> getRoleByUserId(String userId);

	List<RoleForm> findRoleListWithStatus(Map<String, Object> paramMap);

}
