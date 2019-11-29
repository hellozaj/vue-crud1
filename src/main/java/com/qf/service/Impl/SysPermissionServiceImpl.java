package com.qf.service.Impl;

import com.qf.dao.SysPermissionDao;
import com.qf.domain.TbSysPermission;
import com.qf.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/11/22.
 */
@Service
public class SysPermissionServiceImpl implements SysPermissionService {
    @Autowired
    private SysPermissionDao sysPermissionDao;

    @Override
    public List<TbSysPermission> findUserPermissionByUsername(String name) {
        return sysPermissionDao.findUserPermissionByUsername(name);
    }
}
