package com.example.pi_dev_poker_planning.Repositories;

import com.example.pi_dev_poker_planning.Entities.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
