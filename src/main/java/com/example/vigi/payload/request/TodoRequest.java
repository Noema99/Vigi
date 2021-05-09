package com.example.vigi.payload.request;

import com.example.vigi.models.User;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

public class TodoRequest {

    @NotBlank
    @Size(max = 50)
    private String id;

    @NotBlank
    @Size(max = 50)
    private String task;

    @NotBlank
    @Size(max = 50)
    private Date date;

    private boolean done;

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
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

    public TodoRequest() {
    }

    @ManyToOne
    @JoinColumn(name = "user_email")
    private User user;



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
