package com.example.pi_dev_4eme__poker_planning.Services;

import com.example.pi_dev_4eme__poker_planning.Entities.Estimation;
import com.example.pi_dev_4eme__poker_planning.Entities.Iteration;

import java.util.List;

public interface IEstimationServices {
    Estimation AddNewEstimation(Estimation estimation);
    public Estimation AddEstimationAffectIteration( Estimation estimation,long id);
    public List<Estimation> ShowEstimationsForOneIterations(long id);
}
