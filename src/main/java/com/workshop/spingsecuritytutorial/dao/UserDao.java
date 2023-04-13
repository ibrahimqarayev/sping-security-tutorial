package com.workshop.spingsecuritytutorial.dao;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class UserDao {

    private final static List<UserDetails> APPLICATION_USERS = Arrays.asList(
            new User(
                    "qarayevibrahimm@gmail.com",
                    "admin$password",
                    Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"))
            ),
            new User(
                    "usermail@gmail.com",
                    "user$password",
                    Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
            )
    );

    public UserDetails findUsersByEmail(String email) {
        return APPLICATION_USERS
                .stream()
                .filter(userDetails -> userDetails.getUsername().equals(email))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("User not found !"));
    }

}
