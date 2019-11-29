package com.qf.controller;

import com.qf.domain.Userinfo;
import com.qf.response.UserinfoResponse;
import com.qf.service.UserinfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Created by Administrator on 2019/11/27.
 */
@RestController
public class UserinfoController {
    @Autowired
    private UserinfoService userinfoService;

    @RequestMapping("/findAll/{size}/{page}")
    public UserinfoResponse findAll(@PathVariable("size") Integer size, @PathVariable("page")Integer page) {
        //System.out.println(userinfoService.findAll(size,page));
        System.out.println("这是8014的访问");
        return userinfoService.findAll(size,page);
    }

    //@RequiresPermissions(value = {"user_edit"})
    @RequestMapping(value = "/findOne",method = RequestMethod.POST)
    public Userinfo findOne(@RequestBody Userinfo userinfo){
        return userinfoService.findById(userinfo.getId());
    }

    @RequestMapping(value ="/userupdate",method = RequestMethod.POST)
    public Userinfo userupdate(@RequestBody Userinfo userinfo){
        return userinfoService.saveAndFlush(userinfo);
    }

    @RequestMapping(value = "/userdelete",method = RequestMethod.POST)
    public String userdelete(@RequestBody Userinfo userinfo){
        return userinfoService.deleteById(userinfo);
    }
}
