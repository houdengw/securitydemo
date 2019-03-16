package com.hdw.service;

import com.hdw.entity.SysPermission;

import java.util.List;

/**
 * Title: evils
 * CreateDate:  2019/3/11
 *
 * @author houdengw
 * @version 1.0
 */
public interface IPermissionService {

    List<SysPermission> findAll();
}
