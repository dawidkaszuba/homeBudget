package pl.dawidkaszuba.homeBudget.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.dawidkaszuba.homeBudget.entity.User;
import pl.dawidkaszuba.homeBudget.model.UserDTO;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                new ArrayList<>());
    }

    public User save(UserDTO user) {
        User newUser = new User();
        newUser.setUserName(user.getUserName());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userService.save(newUser);
    }
}
