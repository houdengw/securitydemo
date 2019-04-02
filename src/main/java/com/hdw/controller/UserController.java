package com.hdw.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hdw.entity.SysUser;
import com.hdw.service.IUserService;
import com.hdw.util.ApiResponse;
import com.hdw.util.EntityToDTO;
import com.hdw.util.SecurityUtil;
import com.hdw.entity.dto.SysUserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
        user = (SysUser) EntityToDTO.populate(postUserData,user);
        user.setCreateTime(new Date());
        user.setCrUser(SecurityUtil.getCurrentUser());
        user = userService.saveUser(user);
        SysUserDTO sysUserDTO =  new SysUserDTO();
        sysUserDTO = (SysUserDTO) EntityToDTO.populate(user,sysUserDTO);

        return ApiResponse.ofSuccess(sysUserDTO);
    }

}
