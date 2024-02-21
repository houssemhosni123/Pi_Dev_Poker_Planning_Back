package com.example.pi_dev_4eme__poker_planning.Services;

import com.example.pi_dev_4eme__poker_planning.Entities.Estimation;
import com.example.pi_dev_4eme__poker_planning.Repositories.EstimationRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstimationService implements IEstimationServices{
    @Autowired
    EstimationRepositories estimationRepositories;
    @Override
    public Estimation AddNewEstimation(Estimation estimation) {
        return estimationRepositories.save(estimation);
    }
}
