package org.itstep.service.security;

import org.itstep.service.BusinessService;
import org.itstep.service.UserService;
import org.itstep.service.dto.BusinessDto;
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
    private final BusinessService businessService;
    private final PasswordEncoder passwordEncoder;

    public SecurityService(UserService userService, PasswordEncoder passwordEncoder, BusinessService businessService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.businessService = businessService;
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

        SecurityContext emptyContext = SecurityContextHolder.createEmptyContext();
        emptyContext.setAuthentication(new UsernamePasswordAuthenticationToken(userDto, userDto.getPassword(),
                AuthorityUtils.createAuthorityList(userDto.getRole())));
        SecurityContextHolder.setContext(emptyContext);

        return SecurityContextHolder.getContext().getAuthentication();
    }


    @Transactional
    public Authentication registerBusiness(BusinessDto businessDto) {
        try {
            businessDto.setRole("ROLE_BUSINESS");
            businessDto.setPassword(passwordEncoder.encode(businessDto.getPassword()));
            businessService.save(businessDto);
        } catch (Exception e) {
            return null;
        }

        SecurityContext emptyContext = SecurityContextHolder.createEmptyContext();
        emptyContext.setAuthentication(new UsernamePasswordAuthenticationToken(businessDto, businessDto.getPassword(),
                AuthorityUtils.createAuthorityList(businessDto.getRole())));
        SecurityContextHolder.setContext(emptyContext);

        return SecurityContextHolder.getContext().getAuthentication();
    }
}
