package org.itstep.service.mapper;

import org.itstep.domain.Person;
import org.itstep.service.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDto, Person> {
    @Mapping(source = "id", target = "id")
    Person toEntity(UserDto user);

    UserDto toDto(Person userDto);

}