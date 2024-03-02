package com.example.pi_dev_4eme__poker_planning.Repositories;

import com.example.pi_dev_4eme__poker_planning.Entities.Role;
import com.example.pi_dev_4eme__poker_planning.Entities.StatusUser;
import com.example.pi_dev_4eme__poker_planning.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

        Optional<User> findByEmail(String email);
        @Query("SELECT COUNT(u) FROM User u WHERE u.rolee = :role")
        int countUsersByRole(@Param("role") Role role);
}
