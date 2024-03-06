package com.example.pi_dev_poker_planning.Controllers;

import com.example.pi_dev_poker_planning.Entities.Feedback;
import com.example.pi_dev_poker_planning.Payload.Request.FeedbackRequest;
import com.example.pi_dev_poker_planning.Services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackController {

    private final FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping
    public ResponseEntity<Feedback> createFeedback(@RequestBody FeedbackRequest feedback) {
        Feedback createdFeedback = feedbackService.saveFeedback(feedback);
        return new ResponseEntity<>(createdFeedback, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable Long id) {
        Feedback feedback = feedbackService.getFeedbackById(id);
        if (feedback != null) {
            return new ResponseEntity<>(feedback, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Feedback>> getAllFeedbacks() {
        List<Feedback> feedbacks = feedbackService.getAllFeedbacks();
        return new ResponseEntity<>(feedbacks, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable Long id) {
        feedbackService.deleteFeedbackById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
