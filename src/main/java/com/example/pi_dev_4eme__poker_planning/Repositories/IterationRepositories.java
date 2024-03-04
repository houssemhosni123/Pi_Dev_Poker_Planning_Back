package com.example.pi_dev_4eme__poker_planning.Repositories;

import com.example.pi_dev_4eme__poker_planning.Entities.Iteration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IterationRepositories extends JpaRepository<Iteration,Long> {
   Iteration findIterationByIdIteration(long Iteration);
   @Query("SELECT i FROM Iteration i ORDER BY i.idIteration DESC LIMIT 1")
   Iteration findLatestIteration();
}
