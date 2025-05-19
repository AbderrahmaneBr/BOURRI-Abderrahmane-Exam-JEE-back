package org.example.examback.domain.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.examback.domain.enums.StatutCredit;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", length = 4)
@NoArgsConstructor
@AllArgsConstructor
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Date dateDemande;
    StatutCredit statut;
    Date dateAcceptation;
    Double montant;
    Long dureeRemboursement;
    Double tauxInteret;
    @ManyToOne
    Client client;
    @OneToMany(mappedBy = "credit")
    List<Remboursement> remboursements;
}
