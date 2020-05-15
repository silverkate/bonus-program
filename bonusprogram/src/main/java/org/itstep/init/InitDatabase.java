package org.itstep.init;


import org.itstep.domain.Person;
import org.itstep.repositories.BusinessRepository;
import org.itstep.repositories.UserRepository;
import org.itstep.service.BusinessService;
import org.itstep.service.TransactionService;
import org.itstep.service.UserService;
import org.itstep.service.dto.BusinessDto;
import org.itstep.service.dto.TransactionDto;
import org.itstep.service.dto.UserDto;
import org.itstep.service.mapper.BusinessMapper;
import org.itstep.service.mapper.TransactionMapper;
import org.itstep.service.mapper.UserMapper;
import org.itstep.service.security.SecurityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Profile("dev")
@Component
public class InitDatabase {
    final UserService userService;
    final BusinessService businessService;
    final TransactionService transactionService;
    final UserRepository userRepository;
    final BusinessRepository businessRepository;

    final BusinessMapper businessMapper;

    final SecurityService securityService;


    private static boolean inited;
    final private TransactionMapper transactionMapper;
    final private UserMapper userMapper;

    public InitDatabase(UserService userService, BusinessService businessService, TransactionService transactionService, UserRepository userRepository, BusinessRepository businessRepository, BusinessMapper businessMapper, SecurityService securityService, TransactionMapper transactionMapper, UserMapper userMapper) {
        this.userService = userService;
        this.businessService = businessService;
        this.transactionService = transactionService;
        this.userRepository = userRepository;
        this.businessRepository = businessRepository;
        this.businessMapper = businessMapper;
        this.securityService = securityService;
        this.transactionMapper = transactionMapper;
        this.userMapper = userMapper;
    }

    @PostConstruct
    public void init() {
        if (inited) return;

        // Init user
        UserDto userDto = new UserDto( "Name", "LastName", "0990909909", "email@gmail.com", "pass");
        userDto.setRole("ROLE_USER");
        securityService.register(userDto);
//        userService.save(userDto);
        // Init business
        BusinessDto businessDto = new BusinessDto("displayName", "officialName", "0909990909", "CEOName", "email@email.com", "kindOfActivity", "code1", "code2", "account", "pass");
        businessDto.setRole("ROLE_BUSINESS");
        securityService.registerBusiness(businessDto);
        //businessService.save(businessDto);

        //Init transactions
        /*TransactionDto transactionDto1 = new TransactionDto(LocalDate.now(), 100, 5, 100, userMapper.toEntity(userDto), businessMapper.toEntity(businessDto));
        TransactionDto transactionDto2 = new TransactionDto(LocalDate.now(), 100, 5, 95, userMapper.toEntity(userDto), businessMapper.toEntity(businessDto));
        transactionService.save(transactionDto1);
        transactionService.save(transactionDto2);*/

        inited = true;
    }
}