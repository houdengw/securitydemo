package com.hdw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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


    @GetMapping("/hello")
    @ResponseBody
    public String Hello(){
        return "Hello Security Test";
    }
}
