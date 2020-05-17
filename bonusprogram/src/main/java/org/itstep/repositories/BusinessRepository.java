package org.itstep.repositories;

import org.itstep.domain.Business;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRepository extends JpaRepository<Business, Integer> {
    Business findUserByPhone(String userName);
}
