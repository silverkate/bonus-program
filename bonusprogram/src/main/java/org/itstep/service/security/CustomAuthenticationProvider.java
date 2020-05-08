package org.itstep.service.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomAuthenticationProvider implements AuthenticationProvider {

    final CustomDetailsService customDetailsService;
    final PasswordEncoder passwordEncoder;

    @Autowired
    public CustomAuthenticationProvider(CustomDetailsService customDetailsService, PasswordEncoder passwordEncoder) {
        this.customDetailsService = customDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();
        UserDetails userDetails = null;
        try {
            userDetails = customDetailsService.loadUserByUsername(username);
            if(!passwordEncoder.matches(password,userDetails.getPassword())){
                throw new BadCredentialsException("User is not found");
            }
        } catch (Exception e) {
            log.error("User is not found.");
            throw new BadCredentialsException("User is not found", e);
        }
        return new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(),userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UsernamePasswordAuthenticationToken.class.equals(aClass);
    }
}
