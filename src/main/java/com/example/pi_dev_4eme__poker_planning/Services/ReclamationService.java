package com.example.pi_dev_4eme__poker_planning.Services;

import com.example.pi_dev_4eme__poker_planning.Entities.Reclamation;
import com.example.pi_dev_4eme__poker_planning.Entities.Reunion;
import com.example.pi_dev_4eme__poker_planning.Repositories.ReclamationRepositories;
import com.example.pi_dev_4eme__poker_planning.Repositories.ReunionRepositories;
import com.example.pi_dev_4eme__poker_planning.Repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReclamationService  implements IReclamationRepositories{
    @Autowired
    ReclamationRepositories reclamationRepositories ;
    @Autowired
    UserRepositories userRepositories ;
    @Autowired
    ReunionRepositories reunionRepositories ;
          // @Override
            //public void  addReclamtion(Reclamation reclamation, Long idUser, Long idReunion) {
                //User user = userRepositories.findById(idUser).orElse(null);
              //  Reunion reunion = reunionRepositories.findById(idReunion).orElse(null);
                //reclamation.setUserReclamer(user);
                //reclamation.setReunionReclamer(reunion);
                //reclamationRepositories.save(reclamation);
        //}

    @Override
    public void deleteReclamation(Long id) {
        reclamationRepositories.deleteById(id);
    }

    @Override
    public Reclamation addReclamtion(Reclamation reclamation, String titre_Reunion) {
        Reunion reunion = reunionRepositories.findReunionByTitre(titre_Reunion);

        if (reunion != null) {
            // Obtenir la date de dépôt de la réunion
            LocalDateTime dateDepotReunion = reunion.getDatedepot();

            // Obtenir la date et l'heure actuelles
            LocalDateTime now = LocalDateTime.now();

            // Calculer la différence de temps en minutes entre la date de dépôt de la réunion et la date actuelle
            long minutesDifference = ChronoUnit.MINUTES.between(dateDepotReunion, now);

            // Vérifier si la différence de temps est inférieure ou égale à 3 minutes
            if (minutesDifference <= 3) {
                // Si oui, assigner la réunion à la réclamation
                reclamation.setReunionReclamer(reunion);

                // Assigner la date de soumission actuelle à la réclamation
                reclamation.setDateSoumission(now);

                // Enregistrer la réclamation
                return reclamationRepositories.save(reclamation);
            } else {
                // Si non, jetez une exception indiquant que le délai est dépassé
                throw new RuntimeException("Désolé, vous avez dépassé le délai pour ajouter une réclamation.");
            }
        } else {
            // Si la réunion n'existe pas, retourner null pour indiquer que la réclamation ne peut pas être ajoutée
            return null;
        }
    }

    @Override
    public List<Reclamation> getAllReclamation() {
        return reclamationRepositories.findAll();
    }

    @Override
    public Reclamation updateReclamation(Long id, Reclamation updatedReclamation) {
        Reclamation existingReclamation = reclamationRepositories.findById(id).orElse(null);

        if (existingReclamation != null) {
            existingReclamation.setTitre_Reclamation(updatedReclamation.getTitre_Reclamation());

            existingReclamation.setContenu_Reclamation(updatedReclamation.getContenu_Reclamation());
            // Autres attributs à mettre à jour si nécessaire

            return reclamationRepositories.save(existingReclamation);
        } else {
            return null; // Gérer le cas où la réunion n'existe pas
        }
    }

}



