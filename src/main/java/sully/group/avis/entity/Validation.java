package sully.group.avis.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "validation")
public class Validation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Instant dateCreation;
    private Instant expiration;
    private Instant activation;
    private String code;

    @OneToOne(cascade = CascadeType.ALL)
    private Utilisateur utilisateur;
}
