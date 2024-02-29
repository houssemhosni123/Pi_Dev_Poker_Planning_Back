package com.example.pi_dev_4eme__poker_planning.Repositories;

import com.example.pi_dev_4eme__poker_planning.Entities.Estimation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstimationRepositories extends JpaRepository<Estimation,Long> {

    List<Estimation> findEstimationsByIteration_IdIteration(long idIteration);
}
