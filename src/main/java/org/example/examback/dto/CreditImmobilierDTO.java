package org.example.examback.dto;

import jakarta.persistence.*;
import lombok.Data;
import org.example.examback.domain.entites.Client;
import org.example.examback.domain.entites.Remboursement;
import org.example.examback.domain.enums.StatutCredit;
import org.example.examback.domain.enums.TypeBien;

import java.util.Date;
import java.util.List;

@Data
public class CreditImmobilierDTO extends CreditDTO {
    Long id;
    Date dateDemande;
    StatutCredit statut;
    Date dateAcceptation;
    Double montant;
    Long dureeRemboursement;
    Double tauxInteret;
    ClientDTO client;
    TypeBien bienFinancier;
    List<RemboursementDTO> remboursements;
}
