package com.example.pi_dev_4eme__poker_planning.Services;

import com.example.pi_dev_4eme__poker_planning.Entities.User;
import com.example.pi_dev_4eme__poker_planning.Repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices implements IUserRepositories {
    @Autowired
    UserRepositories userRepositories ;
    @Override
    public User addUser(User user) {
        return userRepositories.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepositories.findAll();
    }
}
