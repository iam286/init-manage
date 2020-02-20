package com.y4l3.platform.module.sys.dao;

import com.y4l3.platform.common.base.BaseDao;
import com.y4l3.platform.module.sys.entity.Phonogram;

import java.util.List;

/**
 * @author Kay
 * @version 1.0 2020/2/20
 */
public interface PhonogramDao extends BaseDao<Phonogram> {
    /**
     * 通过类型获取音标
     * @param type 类型
     * @return
     */
    List<Phonogram> getPhoneticsByType(int type);
}
