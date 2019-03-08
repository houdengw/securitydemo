package com.hdw.config;

import com.hdw.handler.CusAuthenticationFailHandler;
import com.hdw.handler.CusAuthenticationSuccessHandler;
import com.hdw.handler.CusLogoutSuccessHandler;
import com.hdw.service.CusUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Title: evils
 * CreateDate:  2019/3/7
 *
 * @author houdengw
 * @version 1.0
 */
@Configuration
@EnableWebSecurity
public class CusSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    protected PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    protected UserDetailsService detailsService(){
        return new CusUserDetailService();
    }

    @Bean
    public CusAuthenticationSuccessHandler authenticationSuccessHandler(){
        return  new CusAuthenticationSuccessHandler();
    }

    @Bean
    public CusAuthenticationFailHandler authenticationFailHandler(){
        return new CusAuthenticationFailHandler();
    }

    @Bean
    public CusLogoutSuccessHandler logoutSuccessHandler(){
        return new CusLogoutSuccessHandler();
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/test/**").permitAll()
                .anyRequest().authenticated()
                .and().formLogin()
                .loginProcessingUrl("/login")
                .successHandler(authenticationSuccessHandler())
                .failureHandler(authenticationFailHandler())
                .and()
                .logout().logoutUrl("/logout")
                .logoutSuccessHandler(logoutSuccessHandler());
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN").and().passwordEncoder(passwordEncoder());
        auth.userDetailsService(detailsService()).passwordEncoder(passwordEncoder());
    }


}
