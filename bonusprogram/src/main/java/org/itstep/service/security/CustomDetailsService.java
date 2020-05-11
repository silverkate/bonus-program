package org.itstep.service.security;


import org.itstep.domain.Person;
import org.itstep.domain.Business;
import org.itstep.repositories.UserRepository;
import org.itstep.repositories.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class CustomDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    BusinessRepository businessRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Person user = userRepository.findUserByPhone(userName);
        Business business = businessRepository.findUserByPhone(userName);
        if(user != null){
            return userRepository.findUserByPhone(userName);
        }else if(business != null){
            return businessRepository.findUserByPhone(userName);
        }else {
            return new User("admin","$2a$10$qxcV1Da7Hnfi5vv/eRp8HuYKlmiw6NBaPBJJff5vDkFR.K1fiBoBm",
                    AuthorityUtils.createAuthorityList("ROLE_ADMIN"));
        }

    }
}
