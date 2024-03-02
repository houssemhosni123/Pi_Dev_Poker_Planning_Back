package com.example.pi_dev_4eme__poker_planning.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserStory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long IdUserStory;
    String Titre_US;
    String Description_US;
    @Enumerated(EnumType.STRING)
    StatutUserStory Statut_US;
    Long Velocite_US;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonIgnore
    Projet projet;
    //@ManyToOne
   // SprintBacklog sprintBacklog;

    //@OneToMany(cascade = CascadeType.ALL)
    //List<TacheTechnique> tacheTechniques;

   //hethy fil entites UserStory
    //@ManyToOne
    //Session session;

}
