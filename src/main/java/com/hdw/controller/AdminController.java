package com.hdw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Title: evils
 * CreateDate:  2019/3/7
 *
 * @author houdengw
 * @version 1.0
 */
@RequestMapping("/admin")
@Controller
public class AdminController {

    @RequestMapping("/home")
    @ResponseBody
    public String home(){
        return "This is homepage";
    }
}
