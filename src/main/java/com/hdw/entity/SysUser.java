package com.hdw.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Title: evils
 * CreateDate:  2019/3/7
 *
 * @author houdengw
 * @version 1.0
 */
@Entity
@Table(name = "user")
public class SysUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    private String phone;
    private String email;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "update_time")
    private Date updateTime;
    @Column(name = "last_login_time")
    private Date lastLoginTime;

    @Transient
    private  Collection<? extends GrantedAuthority> grantedAuthority;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="user_role",joinColumns = {@JoinColumn(name="user_id",referencedColumnName = "id")}
    ,inverseJoinColumns = {@JoinColumn(name="role_id",referencedColumnName = "id")})
    private List<Role> roles;

    public SysUser(String username) {
        this.name = username;
    }

    public SysUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public String getUsername() {
        return this.name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthority;
    }

    @Override
    public String getPassword() {
        return this.password;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Collection<? extends GrantedAuthority> getGrantedAuthority() {
        return grantedAuthority;
    }

    public void setGrantedAuthority(Collection<? extends GrantedAuthority> grantedAuthority) {
        this.grantedAuthority = grantedAuthority;
    }
}
