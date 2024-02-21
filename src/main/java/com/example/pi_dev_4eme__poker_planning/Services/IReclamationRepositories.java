package com.example.pi_dev_4eme__poker_planning.Services;

import com.example.pi_dev_4eme__poker_planning.Entities.Reclamation;

public interface IReclamationRepositories
{
    public void addReclamtion (Reclamation reclamation , Long idUser , Long idReunion);
    public  void deleteReclamation(Long id);


}
