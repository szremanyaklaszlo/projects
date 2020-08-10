package com.training.sportsbetting.security;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.training.sportsbetting.domain.User;

public class DefaultUserDetails implements UserDetails {

    /**
     * 
     */
    private static final long serialVersionUID = -6628274928240301283L;
    private String email;
    private String password;
    private boolean active;
    //private GrantedAuthority authority;
    
    public DefaultUserDetails(User user) {
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.active = true;
        //this.authority = user.getAuthority();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("USER_ROLE"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return active;
    }

    @Override
    public boolean isAccountNonLocked() {
        return active;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return active;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }

}
