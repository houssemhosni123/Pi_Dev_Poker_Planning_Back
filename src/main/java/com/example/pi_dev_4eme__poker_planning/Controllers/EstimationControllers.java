package com.example.pi_dev_4eme__poker_planning.Controllers;

import com.example.pi_dev_4eme__poker_planning.Entities.Estimation;
import com.example.pi_dev_4eme__poker_planning.Entities.Iteration;
import com.example.pi_dev_4eme__poker_planning.Services.EstimationService;
import com.example.pi_dev_4eme__poker_planning.Services.IterationServices;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Estimation")

public class EstimationControllers {
    @Autowired
    EstimationService estimationService;

    @PostMapping("/AddEstimation")
    public Estimation AddEstimation(@RequestBody Estimation estimation)
    {
       return estimationService.AddNewEstimation(estimation);
    }
    @PostMapping("/AddIterationWithEstimation")
    @Transactional
    public void AddIterationWithEstimation( @RequestBody  Iteration iteration,  Estimation estimation)
    {
      estimationService.AddIterationWithEstimation(iteration, estimation);
    }



}
