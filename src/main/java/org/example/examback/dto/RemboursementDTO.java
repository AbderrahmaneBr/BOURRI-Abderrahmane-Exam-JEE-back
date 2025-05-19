package org.example.examback.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.example.examback.domain.entites.Credit;
import org.example.examback.domain.enums.TypeRemboursement;

import java.util.Date;

@Data
public class RemboursementDTO {
    Long id;
    Date date;
    Double montant;
    TypeRemboursement type;
    CreditDTO credit;
}
