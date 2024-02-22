package com.example.pi_dev_4eme__poker_planning.Services;

import com.example.pi_dev_4eme__poker_planning.Entities.Estimation;
import com.example.pi_dev_4eme__poker_planning.Entities.Iteration;
import com.example.pi_dev_4eme__poker_planning.Repositories.EstimationRepositories;
import com.example.pi_dev_4eme__poker_planning.Repositories.IterationRepositories;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

@Service
public class EstimationService implements IEstimationServices{
    @Autowired
    EstimationRepositories estimationRepositories;
    @Autowired
    private IterationRepositories iterationRepository;
    @Override
    public Estimation AddNewEstimation(Estimation estimation) {
        return estimationRepositories.save(estimation);
    }
   @Override
   @Transactional()

   public void AddIterationWithEstimation(Iteration iteration, Estimation estimation) {
       if (iteration.getIdIteration() == null) {
           iterationRepository.save(iteration);
       }

       // Initialiser la liste si elle est null

       // Ajouter l'estimation à la liste

       estimation.setIteration(iteration); // Assurez-vous que l'estimation est associée à l'itération

       // Enregistrez l'estimation après avoir associé à l'itération
       estimationRepositories.save(estimation);

    }
}
