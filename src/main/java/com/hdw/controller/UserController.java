package com.hdw.controller;

import com.hdw.entity.SysUser;
import com.hdw.service.IUserService;
import com.hdw.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Title: evils
 * CreateDate:  2019/3/11
 *
 * @author houdengw
 * @version 1.0
 */
@RestController
@RequestMapping("/system/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ApiResponse userList(){

        return  ApiResponse.ofSuccess(userService.findAll());

    }

    @RequestMapping(method = RequestMethod.POST)
    public ApiResponse save(SysUser postUserData){

        SysUser user = new SysUser();
        if(postUserData.getName()!=null&&!postUserData.getName().equals("")){
            user.setName(postUserData.getName());
        }
        user.setPassword(postUserData.getPassword());
        user.setEmail(postUserData.getEmail());
        user.setPhone(postUserData.getPhone());
        user.setCreateTime(new Date());
        user = userService.saveUser(user);

        return ApiResponse.ofSuccess(user);
    }

}
