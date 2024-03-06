package com.example.pi_dev_poker_planning.Controllers;

import com.example.pi_dev_poker_planning.Entities.Survey;
import com.example.pi_dev_poker_planning.Services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/surveys")
public class SurveyController {

    private final SurveyService surveyService;

    @Autowired
    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @PostMapping
    public ResponseEntity<Survey> createSurvey(@RequestBody Survey survey) {
        Survey createdSurvey = surveyService.saveSurvey(survey);
        return new ResponseEntity<>(createdSurvey, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Survey> getSurveyById(@PathVariable Long id) {
        Survey survey = surveyService.getSurveyById(id);
        if (survey != null) {
            return new ResponseEntity<>(survey, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Survey>> getAllSurveys() {
        List<Survey> surveys = surveyService.getAllSurveys();
        return new ResponseEntity<>(surveys, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSurvey(@PathVariable Long id) {
        surveyService.deleteSurveyById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
