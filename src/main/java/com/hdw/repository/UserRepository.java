package com.hdw.repository;

import com.hdw.entity.SysUser;
import org.springframework.data.repository.CrudRepository;

/**
 * Title: evils
 * CreateDate:  2019/3/11
 *
 * @author houdengw
 * @version 1.0
 */
public interface UserRepository extends CrudRepository<SysUser,Long>{

    SysUser findByName(String name);


}
