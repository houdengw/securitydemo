package com.hdw.controller;

import com.hdw.entity.SysUser;
import com.hdw.service.IUserService;
import com.hdw.util.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ApiResponse userList(){

        log.debug("测试DEBUG级别");
        return  ApiResponse.ofSuccess(userService.findAll());

    }

    @RequestMapping(method = RequestMethod.POST)
    public ApiResponse save(@Valid SysUser postUserData){

        log.info("测试slfj开始存储用户{}",postUserData.getName());
        SysUser user = new SysUser();
        user.setName(postUserData.getName());
        user.setPassword(postUserData.getPassword());
        user.setEmail(postUserData.getEmail());
        user.setPhone(postUserData.getPhone());
        user.setCreateTime(new Date());
        user = userService.saveUser(user);



        log.info("测试slfj完成存储用户{},用户ID:{}",user.getName(),user.getId());

        return ApiResponse.ofSuccess(user);
    }

}
