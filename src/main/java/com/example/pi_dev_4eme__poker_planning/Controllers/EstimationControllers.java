package com.example.pi_dev_4eme__poker_planning.Controllers;

import com.example.pi_dev_4eme__poker_planning.Entities.Estimation;
import com.example.pi_dev_4eme__poker_planning.Entities.Iteration;
import com.example.pi_dev_4eme__poker_planning.Services.EstimationService;
import com.example.pi_dev_4eme__poker_planning.Services.IterationServices;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PostMapping("/AddEstimationWithIteration/{idIteration}")
    @Transactional
    public void AddEstimationWithIteration(@RequestBody  Estimation estimation, @PathVariable("idIteration") long idIteration )
    {
      estimationService.AddEstimationAffectIteration(estimation, idIteration);
    }
    @GetMapping("/GetEstimations/{id}")
    public List<Estimation> ShowEstimationsForOneIterations(@PathVariable("id") long id)
    {
       return estimationService.ShowEstimationsForOneIterations(id);
    }




}
