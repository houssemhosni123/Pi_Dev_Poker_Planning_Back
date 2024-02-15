package com.example.pi_dev_4eme__poker_planning.Services;

import com.example.pi_dev_4eme__poker_planning.Entities.Session;

import java.util.List;

public interface ISessionRepositories {
    Session addSession(Session s);

    public void removeSession(Integer idSession);

    public Session modifiySession(Integer idSession, Session updateSession );

    public List<Session> retrieveAllSession();
}
