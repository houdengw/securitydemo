package com.hdw.service;

import com.hdw.entity.SysUser;

import java.util.List;

/**
 * Title: evils
 * CreateDate:  2019/3/11
 *
 * @author houdengw
 * @version 1.0
 */
public interface IUserService {

     SysUser findUserByName(String name);
     List<SysUser> findAll();

     SysUser saveUser(SysUser sysUser);
}
