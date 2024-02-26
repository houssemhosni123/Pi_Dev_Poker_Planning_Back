package com.example.pi_dev_4eme__poker_planning.Services;

import com.example.pi_dev_4eme__poker_planning.Entities.TacheTechnique;

import java.util.List;

public interface ITacheTechniqueServices {
    TacheTechnique createTacheTechnique(Long userStoryId, TacheTechnique tacheTechnique);
    TacheTechnique updateTacheTechnique(Long id, TacheTechnique tacheTechnique);
    List<TacheTechnique> getAllTacheTechniques();
    TacheTechnique getTacheTechniqueById(Long id);
    void deleteTacheTechnique(Long id);
    void unassignTacheTechnique(Long tacheTechniqueId);
}
