package org.example.examback.domain.repositories;

import org.example.examback.domain.entites.Remboursement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemboursementRepository extends JpaRepository<Remboursement, Long> {
}

