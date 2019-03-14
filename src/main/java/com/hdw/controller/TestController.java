package com.hdw.controller;

import com.hdw.entity.SysUser;
import com.hdw.service.IUserService;
import com.hdw.util.ApiResponse;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Title: evils
 * CreateDate:  2019/3/7
 *
 * @author houdengw
 * @version 1.0
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private IUserService userService;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/hello")
    @ResponseBody
    public String Hello(){
        return "Hello Security Test";
    }

    @ResponseBody
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ApiResponse saveUser(SysUser user){

        SysUser sysUser = new SysUser();
        user.setName(user.getName());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setCreateTime(new Date());
        return ApiResponse.ofSuccess(userService.saveUser(sysUser));

    }
}
