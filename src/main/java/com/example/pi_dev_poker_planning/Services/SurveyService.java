package com.example.pi_dev_poker_planning.Services;

import com.example.pi_dev_poker_planning.Entities.Survey;

import java.util.List;

public interface SurveyService {
    Survey saveSurvey(Survey survey);
    Survey getSurveyById(Long id);
    List<Survey> getAllSurveys();
    void deleteSurveyById(Long id);
}