package com.example.demotcs.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import javax.sql.DataSource;
import javax.xml.ws.soap.Addressing;

/**
 * @Author: Salexal.fww
 * @Date: 2018/12/13 21:39
 * @Version 1.0
 * @Type
 */
@Configuration
 @EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSourceMySQL;

    @Bean
    UserDetailsService customUserService(){
        return new CustomUserService();
    }


    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .and()
                .authorizeRequests()
                .antMatchers("/queryAll").permitAll()
                .antMatchers("/list").authenticated()
                .and()
                .csrf().disable();
//                .antMatchers("/*").hasAuthority("admin");
    }



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication().dataSource(dataSourceMySQL)
//                .usersByUsernameQuery(this.getUsersByUsernameQuery())
//                .authoritiesByUsernameQuery(this.getAuthoritiesByUsernameQuery());
//        auth.inMemoryAuthentication()
//                .withUser("zhangsan").password("123456").roles("user");
//        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("user1").password(new BCryptPasswordEncoder().encode("123456")).roles("user");
        auth.userDetailsService(customUserService());



    }

    private String getUsersByUsernameQuery(){
        return "select user_name,password from user where user_name = ? ";
    }

    private String getAuthoritiesByUsernameQuery(){
        return "select username, roles from authority where username = ? ";
    }
}
