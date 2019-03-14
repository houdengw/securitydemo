package com.hdw.controller;

import com.hdw.service.IUserService;
import com.hdw.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Title: evils
 * CreateDate:  2019/3/11
 *
 * @author houdengw
 * @version 1.0
 */
@Controller
@RequestMapping("/system/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/list")
    @ResponseBody
    public ApiResponse userList(){

        return  ApiResponse.ofSuccess(userService.findAll());

    }

}
