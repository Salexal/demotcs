package com.example.demotcs.utils;

import com.example.demotcs.entity.User;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author: Salexal.fww
 * @Date: 2018/12/15 21:24
 * @Version 1.0
 * @Type
 */
public class UserRequest {

        //session 由controller 注入参数传入
        public static String currentUser(HttpSession session) {
            SecurityContextImpl securityContext = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
            return ((UserDetails)securityContext.getAuthentication().getPrincipal()).getUsername();
        }

}
