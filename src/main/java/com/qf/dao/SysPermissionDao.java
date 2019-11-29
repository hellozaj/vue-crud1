package com.qf.dao;

import com.qf.domain.TbSysPermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2019/11/22.
 */
@Mapper
public interface SysPermissionDao {
    //	根据用户登录名查询其所拥有的权限
    List<TbSysPermission> findUserPermissionByUsername(String name);
}
