package com.hdw.security;



import com.hdw.entity.Permission;
import com.hdw.entity.Role;
import com.hdw.entity.SysUser;
import com.hdw.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

/**
 * Title: evils
 * CreateDate:  2019/3/8
 *
 * @author houdengw
 * @version 1.0
 */
public class CusUserDetailService implements UserDetailsService {


    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String name) {
        SysUser sysUser = userService.findUserByName(name);

        if(sysUser == null){
            throw new UsernameNotFoundException("User not Found");
        }

        List<Role> roles = sysUser.getRoles();

        for(Role role:roles){
            List<Permission> permissionList = role.getPermissions();
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            for(Permission permission:permissionList){
                if(permission!=null){
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getName());
                    grantedAuthorities.add(grantedAuthority);
                }
            }
            sysUser.setGrantedAuthority(grantedAuthorities);
        }
        return sysUser;
    }
}
