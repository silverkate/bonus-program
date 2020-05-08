package org.itstep.repositories;


import org.itstep.domain.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
}
