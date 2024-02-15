package com.example.pi_dev_4eme__poker_planning.Controllers;

import com.example.pi_dev_4eme__poker_planning.Entities.Session;
import com.example.pi_dev_4eme__poker_planning.Services.SessionServices;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Session")
public class SessionController {
    @Autowired
    SessionServices iSessionService;
    @PostMapping("/add")
    public Session AddSession(@RequestBody Session s){
        return iSessionService.addSession(s);
    }

    @GetMapping("/get")
    public List<Session> getBloc(){
        List<Session> sessions = iSessionService.retrieveAllSession();
        return sessions;
    }

    @DeleteMapping("/delete/{idSession}")
    public ResponseEntity<?> delete(@PathVariable("idSession") Integer seid ){
        iSessionService.removeSession(seid);
        return new ResponseEntity<>("delete succ"+seid, HttpStatus.CREATED);
    }

    @PutMapping("/update/{idSession}")
    public ResponseEntity<?> update(@PathVariable("idSession") Integer sid, @RequestBody Session updateSession){
        Session session = iSessionService.modifiySession(sid,updateSession);
        if (session !=null){
            return ResponseEntity.ok(session);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aucune Session Trouve Avec l'id" +sid);
        }
    }
}
