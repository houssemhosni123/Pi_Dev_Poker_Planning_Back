package com.example.pi_dev_4eme__poker_planning.Services;

import com.example.pi_dev_4eme__poker_planning.Entities.Reclamation;
import com.example.pi_dev_4eme__poker_planning.Entities.Reunion;
import com.example.pi_dev_4eme__poker_planning.Entities.User;
import com.example.pi_dev_4eme__poker_planning.Repositories.ReclamationRepositories;
import com.example.pi_dev_4eme__poker_planning.Repositories.ReunionRepositories;
import com.example.pi_dev_4eme__poker_planning.Repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReclamationService  implements IReclamationRepositories{
    @Autowired
    ReclamationRepositories reclamationRepositories ;
    @Autowired
    UserRepositories userRepositories ;
    @Autowired
    ReunionRepositories reunionRepositories ;
            @Override
            public void  addReclamtion(Reclamation reclamation, Long idUser, Long idReunion) {
                User user = userRepositories.findById(idUser).orElse(null);
                Reunion reunion = reunionRepositories.findById(idReunion).orElse(null);
                reclamation.setUserReclamer(user);
                reclamation.setReunionReclamer(reunion);
                reclamationRepositories.save(reclamation);
        }

    @Override
    public void deleteReclamation(Long id) {
        reclamationRepositories.deleteById(id);
    }
}
