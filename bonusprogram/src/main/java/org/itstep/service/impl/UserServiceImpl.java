package org.itstep.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.itstep.domain.User_;
import org.itstep.repositories.UserRepository;
import org.itstep.service.UserService;
import org.itstep.service.dto.UserDto;
import org.itstep.service.mapper.UserMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Slf4j
@Service
@Transactional
public class UserServiceImpl implements UserService {

    final UserRepository userRepository;
    final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto save(UserDto dto) {
        log.debug("Request to save User : {}", dto);
        User_ user = userMapper.toEntity(dto);
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    public Page<UserDto> findAll(Pageable pageable) {
        return null;
        /*
        log.debug("Request to get all Users");
        return userRepository.findAll(pageable)
                .map(userMapper::toDto);*/
    }


    @Override
    public Optional<UserDto> findOne(Integer id) {
        log.debug("Request to get User : {}", id);
        return userRepository.findById(id)
                .map(userMapper::toDto);
    }

    @Override
    public void delete(Integer id) {
        log.debug("Request to delete User : {}", id);
        userRepository.deleteById(id);
    }
}
