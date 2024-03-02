package com.example.pi_dev_4eme__poker_planning.Services;

import com.example.pi_dev_4eme__poker_planning.Entities.Projet;
import com.example.pi_dev_4eme__poker_planning.Entities.UserStory;

import java.util.List;
import java.util.Optional;

public interface IUserStoryService {
   /* public UserStory validateAndGetUserStory(Long IdUserStory, Long IdProjet);
    UserStory saveUserStory(UserStory userStory);
    void deleteUserStory(UserStory userStory);*/

    public List<UserStory> getAllUserStorys();
    public Optional<UserStory> getUserStoryByIdUserStory(Long IdUserStory);
    public UserStory saveOrUpdateUserStory(UserStory userStory);
    public void deleteUserStory(Long IdUserStory);
    public UserStory updateUserStory(Long IdUserStory, UserStory userStory);
}
