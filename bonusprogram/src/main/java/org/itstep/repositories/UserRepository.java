package org.itstep.repositories;

import org.itstep.domain.Person;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<Person, Integer> {
    Person findUserByPhone(String userName);
}
