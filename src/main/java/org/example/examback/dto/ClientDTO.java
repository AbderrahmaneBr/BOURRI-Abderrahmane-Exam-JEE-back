package org.example.examback.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.example.examback.domain.entites.Credit;

import java.util.List;

@Data
public class ClientDTO {
    Long id;
    String name;
    String email;
    List<CreditDTO> credits;
}
