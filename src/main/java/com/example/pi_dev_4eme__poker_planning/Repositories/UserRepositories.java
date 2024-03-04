package com.example.pi_dev_4eme__poker_planning.Repositories;

import com.example.pi_dev_4eme__poker_planning.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepositories extends JpaRepository<User,Long> {
    @Query("SELECT u FROM User u WHERE u.Nom_user = :userName")
    User findUsersByNomUser(String userName);
}

