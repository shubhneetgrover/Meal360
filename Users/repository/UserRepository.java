package com.meal360.web.Users.repository;

import com.meal360.web.Users.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<Users, String> {
    Optional<Users> findByUserName(String userName);
}
