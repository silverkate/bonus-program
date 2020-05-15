package org.itstep.repositories;

import org.itstep.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<Person, Integer> {
    Person findUserByPhone(String userName);
}
