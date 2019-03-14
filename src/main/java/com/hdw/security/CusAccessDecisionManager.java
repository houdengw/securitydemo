package com.hdw.security;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Iterator;

/**
 * Title: evils
 * CreateDate:  2019/3/14
 *
 * @author houdengw
 * @version 1.0
 */
@Service
public class CusAccessDecisionManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {

        if(null==configAttributes||configAttributes.size()<=0){
            return;
        }
        String needPermission;
        for(Iterator<ConfigAttribute> iterator = configAttributes.iterator();iterator.hasNext();){
            needPermission = iterator.next().getAttribute();

            for(GrantedAuthority ga:authentication.getAuthorities()){
                if(needPermission.equals(ga.getAuthority())){
                    return;
                }
            }
        }

        throw new AccessDeniedException("no permission");

    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
