package com.hdw.service.impl;

import com.hdw.entity.SysUser;
import com.hdw.repository.UserRepository;
import com.hdw.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Title: evils
 * CreateDate:  2019/3/11
 *
 * @author houdengw
 * @version 1.0
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository repository;


    @Override
    public SysUser findUserByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<SysUser> findAll() {
        return (List<SysUser>) repository.findAll();
    }

    @Override
    public SysUser saveUser(SysUser sysUser) {
        return repository.save(sysUser);
    }

}
