package com.tutego.ch_09.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
public class UserDetailsServiceConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> switch (username) {
            case "user" -> User
                    .withUsername(username)
                    .password("{noop}password") // {noop} tells the DelegatingPasswordEncoder that NoOpPasswordEncoder is to be used
                    .roles("USER")
                    .build();
            default -> throw new UsernameNotFoundException(username);
        };
    }

}