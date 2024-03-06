package com.example.pi_dev_poker_planning.Services;

import com.example.pi_dev_poker_planning.Entities.Feedback;
import com.example.pi_dev_poker_planning.Payload.Request.FeedbackRequest;

import java.util.List;

public interface FeedbackService {
    Feedback saveFeedback(FeedbackRequest feedback);
    Feedback getFeedbackById(Long id);
    List<Feedback> getAllFeedbacks();
    void deleteFeedbackById(Long id);
}
