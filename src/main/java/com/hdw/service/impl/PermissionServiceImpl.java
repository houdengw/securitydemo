package com.hdw.service.impl;

import com.hdw.entity.Permission;
import com.hdw.repository.PermissionRepository;
import com.hdw.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Title: evils
 * CreateDate:  2019/3/14
 *
 * @author houdengw
 * @version 1.0
 */
@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private PermissionRepository permissionRepository;
    @Override
    public List<Permission> findAll() {
        return (List<Permission>) permissionRepository.findAll();
    }
}
