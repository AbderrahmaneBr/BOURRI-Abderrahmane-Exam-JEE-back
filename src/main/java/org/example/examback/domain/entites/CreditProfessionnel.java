package org.example.examback.domain.entites;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("CPro")
@Data
@AllArgsConstructor @NoArgsConstructor
public class CreditProfessionnel extends Credit {
    String motif;
    String raisonSocial;
}
