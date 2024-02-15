package com.example.pi_dev_4eme__poker_planning.Repositories;


import com.example.pi_dev_4eme__poker_planning.Entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SessionRepositories extends JpaRepository<Session, Integer> {
    Optional<Session> findByIdSession(Integer idsession);
}
