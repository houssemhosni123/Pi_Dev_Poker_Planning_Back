package com.example.pi_dev_4eme__poker_planning.Entities;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User implements UserDetails
{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUser;
    private String Nom;
    private String Prenom;
    private String Image;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role rolee;
    private boolean Status;
    private String Tel;
    private String tt;





    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Tache> taches;

    @OneToMany (mappedBy = "user",cascade = CascadeType.ALL)
    Set<Reunion> reunions;

    @ManyToMany (mappedBy = "users",cascade = CascadeType.ALL)
    Set<Reunion>reunionsAssiter;

    @OneToMany(mappedBy = "userReclamer",cascade = CascadeType.ALL)
    Set<Reclamation> reclamations;

    /*@ManyToMany (cascade = CascadeType.ALL)
    Set<Projet>Projets;*/

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Estimation> estimations;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(rolee.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

