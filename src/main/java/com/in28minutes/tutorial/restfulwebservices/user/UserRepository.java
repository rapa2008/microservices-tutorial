package com.in28minutes.tutorial.restfulwebservices.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by RA371996 on 4/16/2019.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
}
