package com.example.pi_dev_4eme__poker_planning.Controllers;


import com.example.pi_dev_4eme__poker_planning.Entities.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String Nom;
    private String Prenom;
    private String email;
    private String password;
    private Role role;
}
