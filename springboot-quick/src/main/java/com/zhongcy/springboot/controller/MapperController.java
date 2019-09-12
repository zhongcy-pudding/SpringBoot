package com.zhongcy.springboot.controller;

import com.zhongcy.springboot.Mapper.IUserMapper;
import com.zhongcy.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zhongcy on 2019/9/11.
 */
@Controller
public class MapperController {
    @Autowired
    private IUserMapper userMapper;
    @RequestMapping("/queryUser")
    @ResponseBody
    public List<User> queryUser(){
        List<User> users = userMapper.queryUserList();
        return users;
    }
}