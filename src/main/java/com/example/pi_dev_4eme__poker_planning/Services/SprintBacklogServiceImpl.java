package com.example.pi_dev_4eme__poker_planning.Services;

import com.example.pi_dev_4eme__poker_planning.Entities.Sprint;
import com.example.pi_dev_4eme__poker_planning.Entities.SprintBacklog;
import com.example.pi_dev_4eme__poker_planning.Entities.UserStory;
import com.example.pi_dev_4eme__poker_planning.Repositories.SprintBacklogRepository;
import com.example.pi_dev_4eme__poker_planning.Repositories.SprintRepository;
import com.example.pi_dev_4eme__poker_planning.Repositories.UserStoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SprintBacklogServiceImpl implements ISprintBacklogServices {

    @Autowired
    SprintBacklogRepository sprintBacklogRepository;
    @Autowired
    UserStoryRepository userStoryRepository;
    @Autowired
    SprintRepository sprintRepository;



    @Override
    public SprintBacklog createSprintBacklog(SprintBacklog sprintBacklog) {
        return sprintBacklogRepository.save(sprintBacklog);
    }

    @Override
    public SprintBacklog updateSprintBacklog(Long id, SprintBacklog sprintBacklog) {
        if (sprintBacklogRepository.existsById(id)) {
            sprintBacklog.setIdSprintBacklog(id);
            return sprintBacklogRepository.save(sprintBacklog);
        } else {
            throw new NotFoundException("SprintBacklog not found with id: " + id);
        }
    }

    @Override
    public List<SprintBacklog> getAllSprintBacklogs() {
        return sprintBacklogRepository.findAll();
    }

    @Override
    public SprintBacklog getSprintBacklogById(Long id) {
        return sprintBacklogRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("SprintBacklog not found with id: " + id));
    }

    @Override
    public void deleteSprintBacklog(Long id) {
        if (sprintBacklogRepository.existsById(id)) {
            sprintBacklogRepository.deleteById(id);
        } else {
            throw new NotFoundException("SprintBacklog not found with id: " + id);
        }
    }


    @Override
    public void assignSprintToSprintBacklog(Long sprintBacklogId, Long sprintId) {
        Optional<SprintBacklog> optionalSprintBacklog = sprintBacklogRepository.findById(sprintBacklogId);
        Optional<Sprint> optionalSprint = sprintRepository.findById(sprintId);

        if (optionalSprintBacklog.isPresent() && optionalSprint.isPresent()) {
            SprintBacklog sprintBacklog = optionalSprintBacklog.get();
            Sprint sprint = optionalSprint.get();

            sprintBacklog.setSprint(sprint);
            sprintBacklogRepository.save(sprintBacklog);
        } else {
            // Gérer le cas où SprintBacklog ou Sprint n'est pas trouvé
            throw new SprintBacklogNotFoundException("SprintBacklog ou Sprint non trouvé");
        }
    }

    @Transactional
    @Override
    public void unassignSprintFromSprintBacklog(Long sprintBacklogId) {
        Optional<SprintBacklog> optionalSprintBacklog = sprintBacklogRepository.findById(sprintBacklogId);

        if (optionalSprintBacklog.isPresent()) {
            SprintBacklog sprintBacklog = optionalSprintBacklog.get();
            sprintBacklog.setSprint(null);  // Désaffecter en mettant le Sprint à null
            sprintBacklogRepository.save(sprintBacklog);
        } else {
            throw new SprintBacklogNotFoundException("SprintBacklog non trouvé");
        }
    }

    @Override
    public List<SprintBacklog> getSprintBacklogsBySprintId(Long sprintId) {

        return sprintBacklogRepository.findBySprintIdSprint(sprintId);
    }
    @Override
    public int getSprintProgression(Long sprintId) {
        long totalSprintBacklogs = sprintBacklogRepository.countBySprintIdSprint(sprintId);
        long sprintBacklogsTermines = sprintBacklogRepository.countBySprintIdSprintAndAndEstTermine(sprintId, true);

        if (totalSprintBacklogs > 0) {
            return (int) ((sprintBacklogsTermines * 100) / totalSprintBacklogs);
        } else {
            return 0;
        }
    }
    public List<SprintBacklog> filterSprintBacklogsByDate(Date startDate, Date endDate) {
        if (startDate != null && endDate != null) {
            return sprintBacklogRepository.findByDateDebutAfterAndDateFinBefore(startDate, endDate);
        } else if (startDate != null) {
            return sprintBacklogRepository.findByDateDebutAfter(startDate);
        } else if (endDate != null) {
            return sprintBacklogRepository.findByDateFinBefore(endDate);
        } else {
            return sprintBacklogRepository.findAll();
        }
    }

}