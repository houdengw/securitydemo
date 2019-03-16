package com.hdw.controller.exception;

import com.hdw.util.ApiResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Title: evils
 * CreateDate:  2019/3/8
 *
 * @author houdengw
 * @version 1.0
 */
@ControllerAdvice
public class AppErrorController {


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public  ApiResponse ErrorHandler(HttpServletRequest request,HttpServletResponse response,Exception e){

        if(e instanceof org.springframework.web.servlet.NoHandlerFoundException){
            return ApiResponse.ofStatus(ApiResponse.Status.NOT_FOUND);
        }else{
            e.printStackTrace();
            return ApiResponse.ofMessage(500,e.getMessage());
        }

    }

    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public ApiResponse ValidationErrorHandler(HttpServletRequest request,HttpServletResponse response,BindException e){
        ObjectError error = e.getBindingResult().getAllErrors().get(0);
        return ApiResponse.ofMessage(500,error.getDefaultMessage());

    }

}
