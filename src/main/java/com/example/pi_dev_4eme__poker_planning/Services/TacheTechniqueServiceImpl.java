package com.example.pi_dev_4eme__poker_planning.Services;

import com.example.pi_dev_4eme__poker_planning.Entities.SprintBacklog;
import com.example.pi_dev_4eme__poker_planning.Entities.TacheTechnique;
import com.example.pi_dev_4eme__poker_planning.Entities.UserStory;
import com.example.pi_dev_4eme__poker_planning.Repositories.SprintBacklogRepository;
import com.example.pi_dev_4eme__poker_planning.Repositories.TacheTechniqueRepository;
import com.example.pi_dev_4eme__poker_planning.Repositories.UserStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TacheTechniqueServiceImpl implements ITacheTechniqueServices {

    @Autowired
    private TacheTechniqueRepository tacheTechniqueRepository;

    @Autowired
    private UserStoryRepository userStoryRepository;

    @Override
    public TacheTechnique createTacheTechnique(TacheTechnique tacheTechnique) {
        // Logique pour créer une tâche technique indépendamment de son affectation à une user story
        tacheTechnique.setDateCreation(new Date());
        return tacheTechniqueRepository.save(tacheTechnique);
    }

    @Override
    public TacheTechnique affecterTacheTechnique(Long userStoryId, TacheTechnique tacheTechnique) {
        UserStory userStory = userStoryRepository.findById(userStoryId)
                .orElseThrow(() -> new NotFoundException("UserStory not found with id: " + userStoryId));

        tacheTechnique.setUserStory(userStory);
        tacheTechnique.setDateCreation(new Date());
        return tacheTechniqueRepository.save(tacheTechnique);
    }

    @Override
    public TacheTechnique updateTacheTechnique(Long id, TacheTechnique tacheTechnique) {
        if (tacheTechniqueRepository.existsById(id)) {
            tacheTechnique.setIdTacheTechnique(id);
            tacheTechnique.setDateModification(new Date());
            return tacheTechniqueRepository.save(tacheTechnique);
        } else {
            throw new NotFoundException("TacheTechnique not found with id: " + id);
        }
    }

    @Override
    public List<TacheTechnique> getAllTacheTechniques() {
        return tacheTechniqueRepository.findAll();
    }

    @Override
    public TacheTechnique getTacheTechniqueById(Long id) {
        return tacheTechniqueRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("TacheTechnique not found with id: " + id));
    }

    @Override
    public void deleteTacheTechnique(Long id) {
        if (tacheTechniqueRepository.existsById(id)) {
            tacheTechniqueRepository.deleteById(id);
        } else {
            throw new NotFoundException("TacheTechnique not found with id: " + id);
        }
    }

    @Override
    public void unassignTacheTechnique(Long tacheTechniqueId) {
        Optional<TacheTechnique> optionalTacheTechnique = tacheTechniqueRepository.findById(tacheTechniqueId);

        if (optionalTacheTechnique.isPresent()) {
            TacheTechnique tacheTechnique = optionalTacheTechnique.get();
            tacheTechnique.setUserStory(null);  // Désaffecter en mettant la UserStory à null
            tacheTechniqueRepository.save(tacheTechnique);
        } else {
            throw new NotFoundException("TacheTechnique not found with id: " + tacheTechniqueId);
        }
    }
    public List<TacheTechnique> searchAdvanced(String query) {
        return tacheTechniqueRepository.findByNomTacheTechniqueContainingOrDescriptionTacheTechniqueContaining(query, query);
    }
}