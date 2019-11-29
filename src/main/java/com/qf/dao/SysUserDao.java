package com.qf.dao;

import com.qf.domain.TbSysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by 54110 on 2019/11/22.
 */
@Mapper
public interface SysUserDao {

    TbSysUser findByUserName(String username);

    Integer add(TbSysUser tbSysUser);

}
