package com.example.pi_dev_4eme__poker_planning.Controllers;

import com.example.pi_dev_4eme__poker_planning.Entities.Reclamation;
import com.example.pi_dev_4eme__poker_planning.Entities.Reunion;
import com.example.pi_dev_4eme__poker_planning.Entities.User;
import com.example.pi_dev_4eme__poker_planning.Services.IReclamationRepositories;
import com.example.pi_dev_4eme__poker_planning.Services.IReunionRepositories;
import com.example.pi_dev_4eme__poker_planning.Services.IUserRepositories;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserControllers {
  @Autowired
    IUserRepositories userRepositories ;
  @Autowired
  IReunionRepositories iReunionRepostories ;
  @Autowired
    IReclamationRepositories reclamationRepositories ;
    private static final Logger logger = LoggerFactory.getLogger(UserControllers.class);

    @PostMapping("/ajouteruser")
    public User addUser (@RequestBody  User user){
        return userRepositories.addUser(user);

    }
    //@PostMapping("/ajouterReunion/{id}")
    //public Reunion addReunion(@RequestBody Reunion reunion,@PathVariable  ("id") Long idUser){
      //return  iReunionRepostories.addReunion(reunion,idUser);
    //}
    @PostMapping("ajouter")
    public Reunion addReunion (@RequestBody Reunion reunion, HttpServletRequest request){
        System.out.println("Requête reçue depuis : " + request.getHeader("Origin"));
        System.out.println("Méthode : " + request.getMethod());
        System.out.println("Corps de la requête : " + reunion.toString());

        // Votre logique pour ajouter la réunion
        return iReunionRepostories.addReunion(reunion);
    }
    @PutMapping("/ajouterReclamation/{idU}/{idR}")
    public void  addReclamtion(@RequestBody Reclamation reclamation,@PathVariable("idU") Long idUser,@PathVariable("idR") Long idReunion) {

   reclamationRepositories.addReclamtion(reclamation,idUser,idReunion);
    }
    @DeleteMapping("delete/{id}")
    public void deleteReunion(@PathVariable Long id) {
      iReunionRepostories.deleteReunion(id);
    }
    @GetMapping("get/{id}")
    public Reunion getReunionById(@PathVariable Long id) {
        return iReunionRepostories.getReunionById(id);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<Reunion> updateReunion(@PathVariable("id") Long id, @RequestBody Reunion updatedReunion) {
        Reunion reunion = iReunionRepostories.updateReunion(id, updatedReunion);
        if (reunion != null) {
            return new ResponseEntity<>(reunion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("delreclamation/{id}")
    public  void deleteReclamation(@PathVariable Long id){
        reclamationRepositories.deleteReclamation(id);
    }


}
