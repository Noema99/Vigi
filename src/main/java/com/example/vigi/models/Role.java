package com.example.vigi.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// @Document specifies domain object to be persisted to MongoDB
@Document(collection = "roles")
public class Role {
    // @Id specifies that this id is unique
    @Id
    private String id;

    private ERole name;

    public Role() {

    }

    public Role(ERole name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }
}
