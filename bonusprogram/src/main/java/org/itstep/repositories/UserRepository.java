package org.itstep.repositories;

import org.itstep.domain.User_;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User_, Integer> {
    User_ findUserByPhone(String userName);
}
