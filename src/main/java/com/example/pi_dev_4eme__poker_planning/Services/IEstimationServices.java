package com.example.pi_dev_4eme__poker_planning.Services;

import com.example.pi_dev_4eme__poker_planning.Entities.Estimation;
import com.example.pi_dev_4eme__poker_planning.Entities.Iteration;

public interface IEstimationServices {
    Estimation AddNewEstimation(Estimation estimation);
    public void AddIterationWithEstimation(Iteration iteration, Estimation estimation);
}
