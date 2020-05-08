package org.itstep.service.mapper;

import org.itstep.domain.User_;
import org.itstep.service.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDto, User_> {
    @Mapping(source = "id", target = "id")
    User_ toEntity(User_ user);

    UserDto toDto(UserDto userDto);

}