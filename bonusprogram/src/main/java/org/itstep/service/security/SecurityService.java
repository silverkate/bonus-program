package org.itstep.service.security;

import org.itstep.service.UserService;
import org.itstep.service.dto.UserDto;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SecurityService {
    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    public SecurityService(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public Authentication register(UserDto userDto) {
        try {
            userDto.setRole("ROLE_USER");
            userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
            userService.save(userDto);
        } catch (Exception e) {
            return null;
        }

        SecurityContext emptyContext = SecurityContextHolder.getContext(); //createEmptyContext();
        emptyContext.setAuthentication(new UsernamePasswordAuthenticationToken(userDto, userDto.getPassword(),
                AuthorityUtils.createAuthorityList(userDto.getRole())));
        SecurityContextHolder.setContext(emptyContext);

        return SecurityContextHolder.getContext().getAuthentication();
    }
}
