package org.example.examback.domain.entites;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("CPer")
@Data
@AllArgsConstructor @NoArgsConstructor
public class CreditPersonnel extends Credit {
    String motif;
}
