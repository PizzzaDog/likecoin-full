package by.academy.security;

import by.academy.pojo.MyUser;
import by.academy.service.MyUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;


@Service("authService")
public class AuthenticationService
        implements UserDetailsService
{
    private static final Logger log = LoggerFactory.getLogger(AuthenticationService.class);

    @Autowired
    MyUserService myUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Searching user: {}", username);
        MyUser myUser = myUserService.findUserByUserName(username);

        if(myUser == null) throw new UsernameNotFoundException("User not found: " + username);

        return new User(
                myUser.getUserName(),
                myUser.getUserPassword(),
                myUser.getRoles()
                        .stream()
                .map(myRole -> new SimpleGrantedAuthority("ROLE_" + myRole.getRoleName()))
                .collect(Collectors.toList()));
    }
}
