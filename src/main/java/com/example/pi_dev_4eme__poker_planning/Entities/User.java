package com.example.pi_dev_4eme__poker_planning.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable
{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUser;
    private String Nom_user;
    private String Prenom_user;
    private String Image_user;
    private String Email_user;
    private String Password_user;
    @Enumerated(EnumType.STRING)
    private Role rolee;
    private boolean Status_User;
    private String Tel_user;




    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Tache> taches;

    @OneToMany (mappedBy = "user",cascade = CascadeType.ALL)
    @JsonManagedReference

    Set<Reunion> reunions;

    @ManyToMany (mappedBy = "users",cascade = CascadeType.ALL)
    @JsonIgnore

   Set<Reunion>reunionsAssiter;

    @OneToMany(mappedBy = "userReclamer",cascade = CascadeType.ALL)
    @JsonIgnore

    Set<Reclamation> reclamations;

    /*@ManyToMany (cascade = CascadeType.ALL)
    Set<Projet>Projets;*/

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Estimation> estimations;
}

