package com.example.pi_dev_4eme__poker_planning.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reunion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idReunion ;
    String titre_Reunion;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")


    Date DateDebut_Reunion;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")

    Date DateFin_Reunion;
    String lieu_Reunion;
    String priorite_Reunion;
    @ManyToOne
    User user ;
    @ManyToMany
    Set<User> users ;
    @OneToMany (mappedBy = "reunionReclamer",cascade = CascadeType.ALL)
    Set<Reclamation>reclamationSet;
}
