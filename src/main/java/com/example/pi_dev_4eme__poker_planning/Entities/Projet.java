package com.example.pi_dev_4eme__poker_planning.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Projet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idProjet;
    String Nom_Projet;
    String Client;
    String Description_Projet;
    @Temporal(TemporalType.DATE)
    Date DateDebut_Projet;
    @Temporal(TemporalType.DATE)
    Date DateFin_Projet;

    @OneToMany(mappedBy = "projet",cascade = CascadeType.PERSIST)
    List<UserStory> userStory;
/*@OneToMany(mappedBy = "projet",cascade = CascadeType.ALL)
    private List<Tache> taches;*/
   /* @ManyToMany(mappedBy = "projets",cascade = CascadeType.ALL)
    Set<User> Users;*/
}
