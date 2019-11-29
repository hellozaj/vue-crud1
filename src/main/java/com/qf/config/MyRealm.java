package com.qf.config;

import com.qf.domain.TbSysPermission;
import com.qf.domain.TbSysUser;
import com.qf.service.SysPermissionService;
import com.qf.service.SysUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysPermissionService sysPermissionService;

    //权限的
    //Authorization授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Object primaryPrincipal = principalCollection.getPrimaryPrincipal();
        List<TbSysPermission> userPermissionByUsername = sysPermissionService.findUserPermissionByUsername((String) primaryPrincipal);
        if (userPermissionByUsername != null && userPermissionByUsername.size() > 0) {

            Collection list = new HashSet<>();
            for (TbSysPermission per : userPermissionByUsername) {
                list.add(per.getPerName());
            }
            //将查到的用户权限存放至shiro中
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            simpleAuthorizationInfo.addStringPermissions(list);
            return simpleAuthorizationInfo;
        }
        return null;
    }


    //登录的
    //Authentication证明、证实
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取到当前登录的用户名
        String name = (String) authenticationToken.getPrincipal();

        //String password="4e7bdb88640b376ac6646b8f1ecfb558";
        //String salt="zhangsan";
        //ByteSource.Util.bytes(salt),
        //通过用户名去数据库查询正确的密码
        TbSysUser user = sysUserService.findByUserName(name);
        if (user != null) {
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user.getLoginName(), user.getPassword(), getName());
            System.out.println(user.getLoginName()+"="+user.getPassword());
            return simpleAuthenticationInfo;
        }
        return null;
    }
}
