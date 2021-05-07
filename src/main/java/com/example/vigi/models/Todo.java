package com.example.vigi.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;


@Document(collection = "todos")

public class Todo {
    @Id
    private String id;

    @NotBlank
    @Size(max = 50)
    private String task;

    @NotBlank
    @Size(max = 20)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private boolean done;


    @ManyToOne
    @JoinColumn(name = "USER_EMAIL")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Todo(String id, String task, Date date, boolean done, User user) {
        this.id=id;
        this.task = task;
        this.date=date;
        this.done=done;
        this.user = user;
    }

    public Todo(String id, String task, Date date) {
        this.id=id;
        this.task = task;
        this.date=date;
    }

    public Todo( String id, String task, Date date, boolean done) {
        this.id=id;
        this.task = task;
        this.date=date;
        this.done=done;
    }

    public Todo(@NotBlank @Size(max = 50) String id) {
        this.id = id;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean getDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Todo() {
    }


}
