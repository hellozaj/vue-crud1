package com.qf.service;

import com.qf.domain.TbSysUser;

/**
 * Created by 54110 on 2019/11/22.
 */
public interface SysUserService {
    TbSysUser findByUserName(String username);

    Integer add(TbSysUser tbSysUser);
}
