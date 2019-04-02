package com.hdw.security;

import com.hdw.entity.SysPermission;
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


    private List<SysPermission> permissionList = null;

    public void loadAllPermissions() {
        permissionList = permissionService.findAll();
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        //如果权限list为空 先获取所有的权限
        if (permissionList == null)
            loadAllPermissions();
        Collection<ConfigAttribute> configAttributes = new ArrayList<>();
        HttpServletRequest request = ((FilterInvocation) o).getHttpRequest();
        for (SysPermission permission : permissionList) {
            String url = permission.getUrl();
            if (new AntPathRequestMatcher(url).matches(request)) {
                ConfigAttribute permissionAttribute = new SecurityConfig(permission.getName());
                configAttributes.add(permissionAttribute);
                //如果有匹配到对应的url 直接返回权限位
                return configAttributes;
            }
        }
        return null;
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
