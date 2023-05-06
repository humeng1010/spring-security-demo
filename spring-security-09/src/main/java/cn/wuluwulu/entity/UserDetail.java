package cn.wuluwulu.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserDetail extends User implements UserDetails {

    private List<SimpleGrantedAuthority> simpleGrantedAuthorities;

    public void setSimpleGrantedAuthorities(List<SimpleGrantedAuthority> simpleGrantedAuthorities) {
        this.simpleGrantedAuthorities = simpleGrantedAuthorities;
    }

    public UserDetail(User user) {
        super(user.getUserId(), user.getUsername(), user.getPassword(), user.getSex(), user.getSex(), user.getEnable(), user.getAccountNoExpired(), user.getCredentialsNoExpired(), user.getAccountNoLocked());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.simpleGrantedAuthorities;
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return super.getAccountNoExpired() == 1;
    }

    @Override
    public boolean isAccountNonLocked() {
        return super.getAccountNoLocked() == 1;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return super.getCredentialsNoExpired() == 1;
    }

    @Override
    public boolean isEnabled() {
        return super.getEnable() == 1;
    }
}
