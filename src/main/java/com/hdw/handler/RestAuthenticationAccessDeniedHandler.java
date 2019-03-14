package com.hdw.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hdw.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Title: evils
 * CreateDate:  2019/3/14
 *
 * @author houdengw
 * @version 1.0
 */
public class RestAuthenticationAccessDeniedHandler implements AccessDeniedHandler {


    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {


        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.getWriter().write(objectMapper.writeValueAsString(ApiResponse.ofStatus(ApiResponse.Status.NO_AUTHORITY)));
    }
}
