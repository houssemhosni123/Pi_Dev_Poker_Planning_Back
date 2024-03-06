package com.example.pi_dev_poker_planning.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "feedbacks")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date",nullable = false)
    private Date date;

    @Column(nullable = false)
    private int evaluation;

    @Column(nullable = false)
    private String description;

    private String role;

    private Boolean anonyme;

    @OneToOne
    @JoinColumn(name = "survey_id", referencedColumnName = "idsurvey")
    private Survey survey;

    // Getters and setters
}