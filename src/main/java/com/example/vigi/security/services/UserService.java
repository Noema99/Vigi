package com.example.vigi.security.services;

import com.example.vigi.models.Provider;
import com.example.vigi.models.User;
import com.example.vigi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public void processOAuthPostLogin(String username) {
        User existUser = repo.getUserByUsername(username);

        if (existUser == null) {
            User newUser = new User();
            newUser.setUsername(username);
            newUser.setProvider(Provider.GOOGLE);

            repo.save(newUser);
        }

    }

}