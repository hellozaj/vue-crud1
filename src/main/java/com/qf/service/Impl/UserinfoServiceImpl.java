package com.qf.service.Impl;

import com.qf.domain.Userinfo;
import com.qf.repositroy.UserinfoRepository;
import com.qf.response.UserinfoResponse;
import com.qf.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

/**
 * Created by Administrator on 2019/11/27.
 */
@Service
public class UserinfoServiceImpl implements UserinfoService {
    @Autowired
    private UserinfoRepository userinfoRepository;

    @Override
    public UserinfoResponse findAll(Integer size, Integer page) {
        if (page < 0) {
            page = 0;
        } else {
            page = page - 1;
        }

        Pageable pages = PageRequest.of(page, size);
        Page<Userinfo> all = userinfoRepository.findAll(pages);
        List<Userinfo> content = all.getContent();
        UserinfoResponse uis = new UserinfoResponse();
        uis.setList(content);
        uis.setTotal(all.getTotalElements());
        uis.setPage(all.getTotalPages());
        return uis;
    }

    @Override
    public Userinfo findById(Integer id) {
        Optional<Userinfo> byId = userinfoRepository.findById(id);
        Userinfo userinfo = null;
        if (byId.isPresent()) {
            userinfo = byId.get();
        }
        return userinfo;
    }

    @Override
    public Userinfo saveAndFlush(Userinfo userinfo) {
        return userinfoRepository.saveAndFlush(userinfo);
    }

    @Override
    public String deleteById(Userinfo userinfo) {
        try {
            userinfoRepository.deleteById(userinfo.getId());
            return "success";
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "fail";
    }
}
