package com.example.pi_dev_4eme__poker_planning.Repositories;

import com.example.pi_dev_4eme__poker_planning.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositories extends JpaRepository<User,Long> {
    User findUserByIdUser(long idUser);
}
