package org.example.examback.domain.entites;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.examback.domain.enums.TypeBien;

@Entity
@Data
@DiscriminatorValue("CImo")
@AllArgsConstructor @NoArgsConstructor
public class CreditImmobilier extends Credit {
    TypeBien bienFinancier;
}
