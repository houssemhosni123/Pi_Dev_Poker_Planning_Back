package com.example.pi_dev_4eme__poker_planning.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
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



    @JsonIgnore
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Tache> taches;
    @JsonIgnore
    @OneToMany (mappedBy = "user",cascade = CascadeType.ALL)
    Set<Reunion> reunions;
    @JsonIgnore
    @ManyToMany (mappedBy = "users",cascade = CascadeType.ALL)
    Set<Reunion>reunionsAssiter;
    @JsonIgnore
    @OneToMany(mappedBy = "userReclamer",cascade = CascadeType.ALL)
    Set<Reclamation> reclamations;

    /*@ManyToMany (cascade = CascadeType.ALL)
    Set<Projet>Projets;*/
    @JsonIgnore
    @OneToOne(mappedBy = "user",cascade = CascadeType.REMOVE)
    private Estimation estimation;
}

