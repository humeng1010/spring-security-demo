package com.red.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * 自定义用户
 */
public class SecurityUser implements UserDetails {

    private Long id;

    private String username;

    @JsonIgnore
    private String password;

    private Boolean accountNonExpired;

    private Boolean accountNonLocked;

    private Boolean credentialsNonExpired;

    private Boolean enabled;

    public SecurityUser() {

    }

    public SecurityUser(SysUser sysUser) {
        this.id = sysUser.getUserId();
        this.username = sysUser.getUsername();
        this.password = sysUser.getPassword();
        // 包装类最好使用equals进行比较因为包装类存在缓存机制
        this.accountNonExpired = sysUser.getAccountNoExpired().equals(1);
        this.accountNonLocked = sysUser.getAccountNoLocked().equals(1);
        this.credentialsNonExpired = sysUser.getCredentialsNoExpired().equals(1);
        this.enabled = sysUser.getEnable().equals(1);
    }

    /**
     * 用户的权限集合
     *
     * @return Collection<? extends GrantedAuthority>
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public String toString() {
        return "SecurityUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", accountNonExpired=" + accountNonExpired +
                ", accountNonLocked=" + accountNonLocked +
                ", credentialsNonExpired=" + credentialsNonExpired +
                ", enabled=" + enabled +
                '}';
    }
}
