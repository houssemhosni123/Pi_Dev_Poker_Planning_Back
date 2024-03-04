package com.example.pi_dev_4eme__poker_planning.Controllers;

import com.example.pi_dev_4eme__poker_planning.API.MailStructure;
import com.example.pi_dev_4eme__poker_planning.API.SendInvitionMail;
import com.example.pi_dev_4eme__poker_planning.Entities.Session;
import com.example.pi_dev_4eme__poker_planning.Entities.User;
import com.example.pi_dev_4eme__poker_planning.Entities.UserStory;
import com.example.pi_dev_4eme__poker_planning.Repositories.SessionRepositories;
import com.example.pi_dev_4eme__poker_planning.Services.ISessionRepositories;
import com.example.pi_dev_4eme__poker_planning.Services.SessionServices;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/Session")
@NoArgsConstructor
public class SessionController {

    @Autowired
    ISessionRepositories sessionRepositories;

    @Autowired
    SendInvitionMail sendInvitionMail;



    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/add")
    public ResponseEntity<Session> AddSession(@RequestBody Session s)   {
        Session newSession= sessionRepositories.addSession(s);
        return ResponseEntity.ok(newSession);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/send/{idSession}/{mail}")
    public ResponseEntity<String> sendMail(@PathVariable Integer idSession, @PathVariable String mail, @RequestBody MailStructure mailStructure) {
        // Récupérer le lien de session
        String sessionLink = sessionRepositories.getLink(idSession);

        // Mettre à jour le lien de session dans MailStructure
        mailStructure.setLinkSession(sessionLink);

        // Envoyer l'e-mail
        sendInvitionMail.sendEmail(mail, mailStructure);
        System.out.println("Voici le lien de session : " + sessionLink);
        // Répondre au client
        return ResponseEntity.ok("Mail sent successfully!");
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/get")
    public List<Session> getSession(){
        List<Session> sessions = sessionRepositories.retrieveAllSession();
        return sessions;

    }


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getUser")
    public List<User> getUser(){
        List<User> users = sessionRepositories.retrieveAlldevolper();
        return users;
    }



   /* @GetMapping("/getUser/{idSession}")
    public List<User> getUser(@PathVariable Integer idSession) {
        List<User> developerUsers = sessionRepositories.getDeveloperUsersForSession(idSession);
        if (developerUsers != null) {
            return developerUsers;
        } else {

            return null;
        }
    }*/
   @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/delete/{idSession}")
    public ResponseEntity<?> delete(@PathVariable("idSession") Integer seid ){
        sessionRepositories.removeSession(seid);
        return new ResponseEntity<>("delete succ"+seid, HttpStatus.CREATED);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/update/{idSession}")
    public ResponseEntity<?> update(@PathVariable("idSession") Integer sid, @RequestBody Session updateSession){
       Session session = sessionRepositories.modifiySession(sid,updateSession);
        if (session !=null){
            return ResponseEntity.ok(session);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aucune Session Trouve Avec l'id" +sid);
        }
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/get/{idsession}")
    public ResponseEntity<?> getbyid(@PathVariable("idsession") Integer Sid){
    Session session =sessionRepositories.retrieveSessionById(Sid);
    if(session !=null){
    return ResponseEntity.ok(session);
    }else{
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("accune Session troouve");
    }
    }







}
