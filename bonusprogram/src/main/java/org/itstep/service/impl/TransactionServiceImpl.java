package org.itstep.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.itstep.domain.Transaction;
import org.itstep.repositories.TransactionRepository;
import org.itstep.service.TransactionService;
import org.itstep.service.dto.TransactionDto;
import org.itstep.service.mapper.TransactionMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Slf4j
@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

    final TransactionRepository transactionRepository;
    final TransactionMapper transactionMapper;

    public TransactionServiceImpl(TransactionRepository transactionRepository, TransactionMapper transactionMapper) {
        this.transactionRepository = transactionRepository;
        this.transactionMapper = transactionMapper;
    }

    @Override
    public TransactionDto save(TransactionDto dto) {
        log.debug("Request to save Transaction : {}", dto);
        Transaction transaction = transactionMapper.toEntity(dto);
        transaction = transactionRepository.save(transaction);
        return transactionMapper.toDto(transaction);
    }

    @Override
    public Page<TransactionDto> findAll(Pageable pageable) {
        log.debug("Request to get all Transactions");
        return transactionRepository.findAll(pageable)
                .map(transactionMapper::toDto);
    }


    @Override
    public Optional<TransactionDto> findOne(Integer id) {
        log.debug("Request to get Transaction : {}", id);
        return transactionRepository.findById(id)
                .map(transactionMapper::toDto);
    }

    @Override
    public void delete(Integer id) {
        log.debug("Request to delete Transaction : {}", id);
        transactionRepository.deleteById(id);
    }
}
