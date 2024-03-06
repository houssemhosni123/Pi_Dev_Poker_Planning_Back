package com.example.pi_dev_4eme__poker_planning.Services;

import com.example.pi_dev_4eme__poker_planning.Entities.StatusUser;
import com.example.pi_dev_4eme__poker_planning.Entities.Tache;
import com.example.pi_dev_4eme__poker_planning.Entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserServices {
    List<User> ShowAllUsers();
    User getUserById(Long userId);
    User updateUserById(Long userId, User updatedUser);
    void activateUserById(Long userId);
    void deactivateUserById(Long userId);
    public List<String> getAllTitreUser();



}
