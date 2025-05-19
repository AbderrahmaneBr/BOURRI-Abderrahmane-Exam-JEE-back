package org.example.examback.domain.repositories;

import org.example.examback.domain.entites.Credit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditRepository extends JpaRepository<Credit, Long> {
}
