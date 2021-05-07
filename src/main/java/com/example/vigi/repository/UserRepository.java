package com.example.vigi.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.vigi.models.User;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.username = :username")
    public User getUserByUsername(@Param("username") String username);
}