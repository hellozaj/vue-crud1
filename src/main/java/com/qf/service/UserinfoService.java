package com.qf.service;

import com.qf.domain.Userinfo;
import com.qf.response.UserinfoResponse;

import java.util.List;


/**
 * Created by Administrator on 2019/11/27.
 */
public interface UserinfoService {

    UserinfoResponse findAll(Integer size, Integer page);
    Userinfo findById(Integer id);

    Userinfo saveAndFlush(Userinfo userinfo);

    String deleteById(Userinfo user);
}
