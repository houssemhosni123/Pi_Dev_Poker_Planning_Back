package com.example.pi_dev_4eme__poker_planning.Repositories;

import com.example.pi_dev_4eme__poker_planning.Entities.Projet;
import com.example.pi_dev_4eme__poker_planning.Entities.UserStory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserStoryRepositorie extends JpaRepository<UserStory,Long> {
   /* UserStory findUserStoriesByIdUserStory(Long IdUserStory);
    Optional<UserStory>findByIdUserStoryAndIdProjet(Long IdUserStory, Long IdProjet);*/
}

