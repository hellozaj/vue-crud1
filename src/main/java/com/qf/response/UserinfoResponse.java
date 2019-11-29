package com.qf.response;

import com.qf.domain.Userinfo;

import lombok.Data;

import java.util.List;

@Data
public class UserinfoResponse {

    private List<Userinfo> list;

    private Integer page;
    private Long total;

}
