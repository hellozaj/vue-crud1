package com.qf.service;

import com.qf.domain.TbSysPermission;

import java.util.List;

/**
 * Created by Administrator on 2019/11/22.
 */
public interface SysPermissionService {
    //	根据用户登录名查询其所拥有的权限
    List<TbSysPermission> findUserPermissionByUsername(String name);
}
