package org.itstep.service.mapper;

import org.itstep.domain.Transaction;
import org.itstep.service.dto.TransactionDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TransactionMapper extends EntityMapper<TransactionDto, Transaction> {
    @Mapping(source = "id", target = "id")
    Transaction toEntity(Transaction transaction);

    TransactionDto toDto(TransactionDto transactionDto);

}