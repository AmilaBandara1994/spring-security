package com.amila.customhttpbasic.security.managers;

import com.amila.customhttpbasic.security.provider.ApiKeyProvider;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import java.security.Provider;

@AllArgsConstructor
public class CustomAuthenticationManager implements AuthenticationManager {

    private final String key;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        var provider =  new ApiKeyProvider(key);

        if(provider.supports(authentication.getClass())){
            provider.authenticate(authentication);
        }
//        else{
//            throw  new BadCredentialsException(":(");
//        }

        return authentication;
    }
}
