package com.example.pi_dev_4eme__poker_planning.Services;

import com.example.pi_dev_4eme__poker_planning.Entities.Projet;

import java.util.List;
import java.util.Optional;

public interface IProjetService {

    //Projet addProject (Projet projet);
    //List<Projet> saveProjets (List<Projet> projets);
   // Projet validateAndGetProjet(Long IdProjet);
    //void deleteProjet(Projet projet);

    public List<Projet> getAllProjets();
    public Optional<Projet> getProjetById(Long idProjet);
    public Projet saveOrUpdateProjet(Projet projet);
    public void deleteProjet(Long idProjet);
    public Projet updateProjet(Long idProjet, Projet projet);



}
