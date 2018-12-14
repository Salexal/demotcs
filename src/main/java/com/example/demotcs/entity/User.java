package com.example.demotcs.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
public class User implements UserDetails {
    @Id
    @GeneratedValue
    private Integer id;
    private String userName;
    private String password;
    private String userIcon;



    @ManyToMany(cascade = {CascadeType.REFRESH},fetch = FetchType.EAGER)
    private List<Authority> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> auths = new ArrayList<>();
        List<Authority> roles = this.getRoles();
        for(Authority authority:roles){
            auths.add(new SimpleGrantedAuthority(authority.getUsername()));
        }
        return auths;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
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


}
