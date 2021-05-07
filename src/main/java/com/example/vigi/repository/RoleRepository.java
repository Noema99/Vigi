package com.example.vigi.repository;


import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.vigi.models.ERole;
import com.example.vigi.models.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}