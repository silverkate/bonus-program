package org.itstep.service.mapper;

import org.itstep.domain.Business;
import org.itstep.service.dto.BusinessDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BusinessMapper extends EntityMapper<BusinessDto, Business> {
    @Mapping(source = "id", target = "id")
    Business toEntity(Business business);

    BusinessDto toDto(BusinessDto businessDto);
}