package com.example.pi_dev_4eme__poker_planning.Services;

import com.example.pi_dev_4eme__poker_planning.Entities.Session;
import com.example.pi_dev_4eme__poker_planning.Repositories.SessionRepositories;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class SessionServices implements ISessionRepositories {

    @Autowired
    private SessionRepositories sessionRepositories;
    @Override
    public Session addSession(Session s) {
        return sessionRepositories.save(s);    }

    @Override
    public void removeSession(Integer idSession) {
        sessionRepositories.deleteById(idSession);
    }

    @Override
    public Session modifiySession(Integer idSession, Session updateSession) {
        Optional<Session> optUpdate = sessionRepositories.findByIdSession(idSession);
        if(optUpdate.isPresent()){
            Session SessionExist = optUpdate.get();

            //SessionExist.setNomSession(updateSession.getNomSession());
            //SessionExist.setDescription(updateSession.getDescription());
            //SessionExist.setDateEtHeureDebut(updateSession.getDateEtHeureDebut());
            SessionExist.setStatut(updateSession.getStatut());
        }
        return null;
    }

    @Override
    public List<Session> retrieveAllSession() {
        List<Session> listSession = sessionRepositories.findAll();
        for (Session S:listSession){
            log.info("Session: "+S);
        }
        return listSession;
    }
}
