package com.example.pi_dev_poker_planning.Repositories;

import com.example.pi_dev_poker_planning.Entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
