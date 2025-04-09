package com.biteup.user_service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.biteup.user_service.model.User;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);  // Returns a single user (if email is unique)
    List<User> findAllByEmail(String email);   // Returns a list of users (if duplicates exist)
}
