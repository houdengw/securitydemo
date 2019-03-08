package com.hdw.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hdw.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Title: evils
 * CreateDate:  2019/3/8
 *
 * @author houdengw
 * @version 1.0
 */
public class CusLogoutSuccessHandler implements LogoutSuccessHandler {


    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.getWriter().write(objectMapper.writeValueAsString(ApiResponse.ofSuccess("登录失败")));
    }
}
