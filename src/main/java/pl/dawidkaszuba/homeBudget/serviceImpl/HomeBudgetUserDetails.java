package pl.dawidkaszuba.homeBudget.serviceImpl;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.dawidkaszuba.homeBudget.entity.Role;
import pl.dawidkaszuba.homeBudget.entity.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HomeBudgetUserDetails implements UserDetails {


    private String userName;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;


    public HomeBudgetUserDetails(User byUsername) {
        this.userName = byUsername.getUserName();
        this.password = byUsername.getPassword();

        List<GrantedAuthority> auths = new ArrayList<>();
        for(Role role : byUsername.getRoles()){
            auths.add(new SimpleGrantedAuthority(role.getName().toUpperCase()));
        }
        this.authorities = auths;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
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
