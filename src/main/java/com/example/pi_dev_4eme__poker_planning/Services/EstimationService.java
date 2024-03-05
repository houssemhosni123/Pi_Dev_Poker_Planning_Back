package com.example.pi_dev_4eme__poker_planning.Services;

import com.example.pi_dev_4eme__poker_planning.Entities.Estimation;
import com.example.pi_dev_4eme__poker_planning.Entities.Iteration;
import com.example.pi_dev_4eme__poker_planning.Entities.User;
import com.example.pi_dev_4eme__poker_planning.Repositories.EstimationRepositories;
import com.example.pi_dev_4eme__poker_planning.Repositories.IterationRepositories;
import com.example.pi_dev_4eme__poker_planning.Repositories.UserRepositories;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import java.util.List;

@Service
public class EstimationService implements IEstimationServices{
    @Autowired
    EstimationRepositories estimationRepositories;
    @Autowired
    private IterationRepositories iterationRepository;
    @Autowired
    UserRepositories userRepositories;
    @Override
    public Estimation AddNewEstimation(Estimation estimation) {
        return estimationRepositories.save(estimation);
    }
   @Override


   public Estimation AddEstimationAffectIteration( Estimation estimation ) {
     //  Iteration iteration = iterationRepository.findIterationByIdIteration(id);
        Iteration iteration = iterationRepository.findLatestIteration();

       estimation.setIteration(iteration);

       // Save the Estimation first to generate its ID
       estimation = estimationRepositories.save(estimation);
         iteration.setDate_IterationFin(estimation.getDateVote());
       // Add Estimation to Iteration and save Iteration
       iteration.getEstimations().add(estimation);
       iterationRepository.save(iteration);

       return estimation;

    }

    @Override
    public List<Estimation> ShowEstimationsForOneIterations(long id) {
        List<Estimation> estimations = estimationRepositories.findEstimationsByIteration_IdIteration(id);
    return estimations;
    }

    @Override
    public List<Estimation> ShowEstimationsForLastIteration() {
        Iteration iteration = iterationRepository.findLatestIteration();
        List<Estimation> estimations = estimationRepositories.findEstimationsByIteration(iteration);
        return estimations;
    }

    @Override
    public Estimation AddEstimationAffectIterationwithUserId(Estimation estimation, long idUser) {
        Iteration iteration = iterationRepository.findLatestIteration();
       User user= userRepositories.findUserByIdUser(idUser);
        estimation.setIteration(iteration);
        estimation.setUser(user);
        // Save the Estimation first to generate its ID
        estimation = estimationRepositories.save(estimation);

        // Add Estimation to Iteration and save Iteration
        iteration.getEstimations().add(estimation);
        iterationRepository.save(iteration);
        user.setEstimation(estimation);
        userRepositories.save(user);
        return estimation;
    }



    /*@Override
    public void AffectUserToEstimation(User user, Estimation estimation) {
        estimation.setUser(user);
        estimationRepositories.save(estimation);
       user.setEstimation(estimation);
       userRepositories.save(user);
    }*/


}
