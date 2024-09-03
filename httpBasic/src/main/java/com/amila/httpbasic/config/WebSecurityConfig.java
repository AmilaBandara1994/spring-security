package com.amila.httpbasic.config;

import com.amila.httpbasic.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class WebSecurityConfig {

//    private final UserRepository userRepository;

//    @Bean
//    public UserDetailsService userDetailsService(){
//        var uds = new InMemoryUserDetailsManager();
//        var u1 = User.withUsername("amila")
//                .password("1234")
//                .authorities("read")
//                .build();
//
//        uds.createUser(u1);
//        return uds;
//    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//        return new
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
