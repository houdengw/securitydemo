package com.hdw.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hdw.entity.SysUser;
import com.hdw.service.IUserService;
import com.hdw.util.ApiResponse;
import com.hdw.util.EntityToDTO;
import com.hdw.web.dto.SysUserDTO;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping(method = RequestMethod.GET)
    public ApiResponse userList(){
        List<SysUserDTO> sysUserDTOList = new ArrayList<>();
        List<SysUser> sysUserList = userService.findAll();
        for(SysUser sysUser:sysUserList){
            SysUserDTO sysUserDTO =  new SysUserDTO();
            sysUserDTO = (SysUserDTO) EntityToDTO.populate(sysUser,sysUserDTO);
            sysUserDTOList.add(sysUserDTO);
        }
        return  ApiResponse.ofSuccess(sysUserDTOList);

    }

    @RequestMapping(method = RequestMethod.POST)
    public ApiResponse save(@Valid SysUser postUserData){
        SysUser user = new SysUser();
        user.setName(postUserData.getName());
        user.setPassword(postUserData.getPassword());
        user.setEmail(postUserData.getEmail());
        user.setPhone(postUserData.getPhone());
        user.setCreateTime(new Date());
        user = userService.saveUser(user);


        return ApiResponse.ofSuccess(user);
    }

}
