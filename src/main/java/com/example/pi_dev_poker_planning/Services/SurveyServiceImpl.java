package com.example.pi_dev_poker_planning.Services;

import com.example.pi_dev_poker_planning.Entities.Survey;
import com.example.pi_dev_poker_planning.Repositories.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyServiceImpl implements SurveyService {

    private final SurveyRepository surveyRepository;

    @Autowired
    public SurveyServiceImpl(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    @Override
    public Survey saveSurvey(Survey survey) {
        return surveyRepository.save(survey);
    }

    @Override
    public Survey getSurveyById(Long id) {
        Optional<Survey> optionalSurvey = surveyRepository.findById(id);
        return optionalSurvey.orElse(null);
    }

    @Override
    public List<Survey> getAllSurveys() {
        return surveyRepository.findAll();
    }

    @Override
    public void deleteSurveyById(Long id) {
        surveyRepository.deleteById(id);
    }
}