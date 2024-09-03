package com.amila.endpointsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // end point level authorization only applicable in web applications
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.httpBasic()
                .and()
                .authorizeRequests()
//                .anyRequest().authenticated() // end point level authorization
//                .anyRequest().permitAll()
//                .anyRequest().denyAll()
//                .anyRequest().hasAnyAuthority("write", "read")
//                .anyRequest().hasAuthority("write")
//                .anyRequest().hasAnyRole()
//                .anyRequest().hasRole("ADMIN")
//                .anyRequest().access("isAuthenticated() and hasAnyAuthority('read')") // Spell -> authorization rule
//                .anyRequest().hasRole("ADMIN")
//                .authorizeRequests(
//                        c -> c.anyRequest().authenticated()
//                )
                .requestMatchers("/demo").authenticated()
                .requestMatchers("/hello").permitAll()
                .and().build();

        //  401 unAuthorized -> authentication fail
        //  403 Forbidden -> Authorization fail

        // matcher method + authorization rule
        // which matcher method should you use and how (anyRequest(), mvcMatches()/ requestMatchers, antMatchers(), regexMatchers())
        // hwo to apply different authorization rules

        // .anyRequest().authenticated()  no matter if user authenticated allows to use all the end points
    }
    @Bean
    public UserDetailsService userDetailsService(){
        var uds = new InMemoryUserDetailsManager();

        var u1 = User.withUsername("amila")
                .password(passwordEncoder().encode("1234"))
//                .roles("MANAGER")
                .authorities("read")
                .build();
        var u2 = User.withUsername("bandara")
                .password(passwordEncoder().encode("1234"))
                .roles("ADMIN")
                .authorities("write")
                .build();
        uds.createUser(u1);
        uds.createUser(u2);
        return uds;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }

}
