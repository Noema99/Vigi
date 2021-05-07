package com.example.vigi.repository;

import com.example.vigi.models.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TodoRepository extends MongoRepository<Todo, String> {

}
