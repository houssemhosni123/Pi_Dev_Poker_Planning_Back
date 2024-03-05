package com.example.pi_dev_4eme__poker_planning.Services;

import com.example.pi_dev_4eme__poker_planning.Entities.Reunion;
import com.example.pi_dev_4eme__poker_planning.Entities.User;

import java.util.List;

public interface IUserRepositories {
    public User addUser (User user);
    List<User> getAllUser();
    public List<String> getAllTitreUser();


}
