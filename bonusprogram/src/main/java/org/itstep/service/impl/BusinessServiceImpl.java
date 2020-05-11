package org.itstep.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.itstep.domain.Business;
import org.itstep.repositories.BusinessRepository;
import org.itstep.service.BusinessService;
import org.itstep.service.dto.BusinessDto;
import org.itstep.service.mapper.BusinessMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@Transactional
public class BusinessServiceImpl implements BusinessService {

    final BusinessRepository businessRepository;
    final BusinessMapper businessMapper;

    public BusinessServiceImpl(BusinessRepository businessRepository, BusinessMapper businessMapper) {
        this.businessRepository = businessRepository;
        this.businessMapper = businessMapper;
    }

    @Override
    public BusinessDto save(BusinessDto dto) {
        log.debug("Request to save Business : {}", dto);
        Business business = businessMapper.toEntity(dto);
        business = businessRepository.save(business);
        return businessMapper.toDto(business);
    }

    @Override
    public Page<BusinessDto> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<BusinessDto> findOne(Integer id) {
        log.debug("Request to get Business : {}", id);
        return businessRepository.findById(id)
                .map(businessMapper::toDto);
    }

    @Override
    public void delete(Integer id) {
        log.debug("Request to delete Business : {}", id);
        businessRepository.deleteById(id);
    }
}

