package org.example.examback.dto;

import lombok.Data;
import org.example.examback.domain.entites.Client;
import org.example.examback.domain.enums.StatutCredit;

import java.util.Date;
import java.util.List;

@Data
public class CreditProfessionnelDTO extends CreditDTO {
    Long id;
    Date dateDemande;
    StatutCredit statut;
    Date dateAcceptation;
    Double montant;
    Long dureeRemboursement;
    Double tauxInteret;
    ClientDTO client;
    String motif;
    String raisonSocial;
    List<RemboursementDTO> remboursements;
}
