package com.hdw.security;

import com.hdw.entity.Permission;
import com.hdw.repository.PermissionRepository;
import com.hdw.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * Title: evils
 * CreateDate:  2019/3/14
 *
 * @author houdengw
 * @version 1.0
 */
@Component
public class CusInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {


    @Autowired
    private IPermissionService permissionService;
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        Collection<ConfigAttribute> configAttributes = new ArrayList<>();
        List<Permission> permissionList = permissionService.findAll();
        HttpServletRequest request = ((FilterInvocation)o).getHttpRequest();
        for(Permission permission:permissionList){
            String url = permission.getUrl();
            if(new AntPathRequestMatcher(url).matches(request)){
                ConfigAttribute permissionAttribute = new SecurityConfig(permission.getName());
                configAttributes.add(permissionAttribute);
            }
        }
        if(configAttributes.size()>0) {
            return configAttributes;
        } else {
            return null;
        }
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
