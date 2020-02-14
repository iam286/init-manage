package com.y4l3.platform.module.sys.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.alibaba.druid.support.json.JSONUtils;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.y4l3.platform.common.aop.annotation.Module;
import com.y4l3.platform.common.base.BaseService;
import com.y4l3.platform.common.message.ResponseResult;
import com.y4l3.platform.common.utils.StringUtils;
import com.y4l3.platform.common.utils.SubjectUtils;
import com.y4l3.platform.module.common.CommonService;
import com.y4l3.platform.module.sys.dao.IconDao;
import com.y4l3.platform.module.sys.dao.MenuDao;
import com.y4l3.platform.module.sys.dao.RoleDao;
import com.y4l3.platform.module.sys.entity.Icon;
import com.y4l3.platform.module.sys.entity.Menu;
import com.y4l3.platform.module.sys.entity.RoleMenu;
import com.y4l3.platform.module.sys.entity.Tree;
import com.y4l3.platform.module.sys.form.RoleForm;

/**
 * 菜单服务
 *
 * @author changzhongq
 * @time 2018年10月20日 下午10:19:41
 */
@Service
@Module("菜单管理")
public class MenuService extends BaseService<Menu, MenuDao> {

    private static final Logger logger = LoggerFactory.getLogger(MenuService.class);

    private static final String ROOT_MENU_ID = "0";

    @Autowired
    private IconDao iconDao;

    @Autowired
    private RoleDao roleDao;

    public Set<String> listRoles(String userId) {
        Set<String> set = new HashSet<>();
        List<RoleForm> roles = roleDao.getRoleByUserId(userId);
        for (RoleForm role : roles) {
            set.add(role.roleId);
        }
        return set;
    }

    public List<Map<String, Object>> findMenuList() {
        return mapper.menuList();
    }

    /**
     * 首页菜单树数据
     *
     * @return
     */
    public List<Tree> findMenuTreesData() {
        List<Tree> menus = mapper.menuTreesData(SubjectUtils.getUserId()).stream().distinct().collect(Collectors.toList());
        logger.info("current user menus:{}", menus);
        //根节点
        List<Tree> mostHeightNodes = new ArrayList<>();
        menus.forEach(menu -> {
            if (ROOT_MENU_ID.equals(menu.getParentId())) {
                Tree tree = menu;
                tree.setHasParent(false);
                mostHeightNodes.add(tree);
            }
            // 如果没有设置菜单图标，展示默认菜单图标
            if (StringUtils.isEmpty(menu.getIcon())) {
                menu.setIcon("layui-icon layui-icon-template-1");
            }
        });
        return buildTree(mostHeightNodes, menus);
    }

    public List<Tree> buildTree(List<Tree> trees, List<Tree> menus) {
        for (Tree tree : trees) {
            String parentId = tree.getId();
            List<Tree> children = new ArrayList<>();
            for (Tree menu : menus) {
                if (parentId.equals(menu.getParentId())) {
                    children.add(menu);
                    tree.setHasChild(true);
                }
            }
            // 递归遍历子节点
            if (children.size() > 0) {
                children = buildTree(children, menus);
            }
            tree.setChildrens(children);
        }
        return trees;
    }

    /**
     * 角色设置菜单权限
     *
     * @param roleId  角色id
     * @param menuIds 菜单id数组
     */
    @Transactional
    public ResponseResult bindMenu(String roleId, String[] menuIds) {
        if (StringUtils.isBlank(roleId)) {
            throw new IllegalArgumentException("传入的roleId为空！");
        }
        CommonService.deleteBy(RoleMenu.class, "roleId", roleId);
        List<RoleMenu> roleMenus = new ArrayList<RoleMenu>();
        for (String menuId : menuIds) {
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setRoleMenuId(StringUtils.getUUID());
            roleMenu.setRoleId(roleId);
            roleMenu.setMenuId(menuId);
            roleMenus.add(roleMenu);
        }
        CommonService.batchInsert(roleMenus.toArray());
        return ResponseResult.ok("保存成功！", null);
    }

    public List<Icon> chooseIcon() {
        return iconDao.selectAll();
    }

    public List<Map<String, Object>> getMenuTreeWithStatus(String roleId) {
        List<Map<String, Object>> result = new ArrayList<>();
        List<Map<String, Object>> menuTreeData = mapper.getMenuTreeWithStatus(roleId);
        for (Map<String, Object> map : menuTreeData) {
            if ("0".equals(map.get("parentId"))) {
                map.put("isLast", false);
                map.put("level", 1);
                result.add(map);
            }
        }
        return buildTreeWithStatus(result, menuTreeData, 2);
    }

    public List<Map<String, Object>> buildTreeWithStatus(List<Map<String, Object>> lastNodes, List<Map<String, Object>> menus, int level) {
        for (Map<String, Object> lastNode : lastNodes) {
            Map<String, Object> checkArrMap = new HashMap<>();
            checkArrMap.put("type", 0);
            checkArrMap.put("isChecked", lastNode.get("checked"));
            lastNode.put("checkArr", checkArrMap);
            String parentId = (String) lastNode.get("id");
            List<Map<String, Object>> childrens = new ArrayList<Map<String, Object>>();
            for (Map<String, Object> menu : menus) {
                if (parentId.equals(menu.get("parentId"))) {
                    Map<String, Object> checkMap = new HashMap<>();
                    checkMap.put("type", 0);
                    checkMap.put("isChecked", menu.get("checked"));
                    menu.put("checkArr", checkMap);
                    menu.put("level", level);
                    childrens.add(menu);
                }
            }
            // 如果有子节点，执行递归查询
            if (childrens.size() > 0) {
                lastNode.put("isLast", false);
                childrens = buildTreeWithStatus(childrens, menus, ++level);
            } else {
                lastNode.put("isLast", true);
            }
            lastNode.put("children", childrens);
        }
        return lastNodes;
    }

}
