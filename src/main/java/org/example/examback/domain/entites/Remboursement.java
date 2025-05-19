package org.example.examback.domain.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.examback.domain.enums.TypeRemboursement;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Remboursement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Date date;
    Double montant;
    TypeRemboursement type;
    @ManyToOne
    Credit credit;
}
