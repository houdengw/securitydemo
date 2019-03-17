package com.hdw.web.dto;


import lombok.Data;

import java.util.Date;

@Data
public class SysUserDTO {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private Date createTime;
    private Date lastLoginTime;

}
