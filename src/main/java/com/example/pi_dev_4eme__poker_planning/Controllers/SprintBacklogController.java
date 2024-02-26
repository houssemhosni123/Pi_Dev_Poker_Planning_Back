package com.example.pi_dev_4eme__poker_planning.Controllers;


import com.example.pi_dev_4eme__poker_planning.Entities.SprintBacklog;
import com.example.pi_dev_4eme__poker_planning.Services.SprintBacklogNotFoundException;
import com.example.pi_dev_4eme__poker_planning.Services.SprintBacklogServiceImpl;
import com.example.pi_dev_4eme__poker_planning.Services.TacheTechniqueServiceImpl;
import com.example.pi_dev_4eme__poker_planning.Services.UserStoryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
    @RequestMapping("/api/sprintBacklogs")
    public class SprintBacklogController {

        @Autowired
        SprintBacklogServiceImpl sprintBacklogService  ;
        @Autowired
        TacheTechniqueServiceImpl tacheTechniqueService;

        @PostMapping
        public ResponseEntity<SprintBacklog> createSprintBacklog(@RequestBody SprintBacklog sprintBacklog) {
            SprintBacklog createdSprintBacklog = sprintBacklogService.createSprintBacklog(sprintBacklog);
            return new ResponseEntity<>(createdSprintBacklog, HttpStatus.CREATED);
        }

        @PutMapping("/{id}")
        public ResponseEntity<SprintBacklog> updateSprintBacklog(@PathVariable Long id,
                                                                 @RequestBody SprintBacklog sprintBacklog) {
            SprintBacklog updatedSprintBacklog = sprintBacklogService.updateSprintBacklog(id, sprintBacklog);
            return new ResponseEntity<>(updatedSprintBacklog, HttpStatus.OK);
        }

        @GetMapping
        public ResponseEntity<List<SprintBacklog>> getAllSprintBacklogs() {
            List<SprintBacklog> sprintBacklogs = sprintBacklogService.getAllSprintBacklogs();
            return new ResponseEntity<>(sprintBacklogs, HttpStatus.OK);
        }

        @GetMapping("/{id}")
        public ResponseEntity<SprintBacklog> getSprintBacklogById(@PathVariable Long id) {
            SprintBacklog sprintBacklog = sprintBacklogService.getSprintBacklogById(id);
            return new ResponseEntity<>(sprintBacklog, HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteSprintBacklog(@PathVariable Long id) {
            sprintBacklogService.deleteSprintBacklog(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    @PutMapping("/{sprintBacklogId}/assign-sprint/{sprintId}")

    public ResponseEntity<String> assignSprintToSprintBacklog(
            @PathVariable Long sprintBacklogId,
            @PathVariable Long sprintId) {
        try {
            sprintBacklogService.assignSprintToSprintBacklog(sprintBacklogId, sprintId);
            return ResponseEntity.ok("SprintBacklog affecté avec succès au Sprint");
        } catch (SprintBacklogNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @PostMapping("/{sprintBacklogId}/assign-userstories")
    public ResponseEntity<String> assignUserStoriesToSprintBacklog(
            @PathVariable Long sprintBacklogId,
            @RequestParam List<Long> userStoryIds) {
        try {
            sprintBacklogService.assignUserStories(sprintBacklogId, userStoryIds);
            return ResponseEntity.ok("UserStories affectées avec succès au SprintBacklog.");
        } catch (SprintBacklogNotFoundException | UserStoryNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @PostMapping("/{sprintBacklogId}/unassign-userstories")
    public ResponseEntity<String> unassignUserStoriesFromSprintBacklog(
            @PathVariable Long sprintBacklogId,
            @RequestParam List<Long> userStoryIds) {
        try {
            sprintBacklogService.unassignUserStories(sprintBacklogId, userStoryIds);
            return ResponseEntity.ok("UserStories désaffectées avec succès du SprintBacklog.");
        } catch (SprintBacklogNotFoundException | UserStoryNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @PostMapping("/{sprintBacklogId}/unassign-sprint")
    public ResponseEntity<String> unassignSprintFromSprintBacklog(@PathVariable Long sprintBacklogId) {
        try {
            sprintBacklogService.unassignSprintFromSprintBacklog(sprintBacklogId);
            return ResponseEntity.ok("Sprint désaffecté avec succès du SprintBacklog.");
        } catch (SprintBacklogNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @GetMapping("/sprintBacklog/{sprintId}")
    public List<SprintBacklog> getSprintBacklogsBySprintId(@PathVariable Long sprintId) {
        return sprintBacklogService.getSprintBacklogsBySprintId(sprintId);
    }

    }

