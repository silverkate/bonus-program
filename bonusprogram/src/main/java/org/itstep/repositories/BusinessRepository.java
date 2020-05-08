package org.itstep.repositories;

import org.itstep.domain.Business;
import org.springframework.data.repository.CrudRepository;


public interface BusinessRepository extends CrudRepository<Business, Integer> {
    Business findUserByPhone(String userName);
}
