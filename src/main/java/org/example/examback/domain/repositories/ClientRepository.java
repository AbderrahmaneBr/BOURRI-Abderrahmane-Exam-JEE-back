package org.example.examback.domain.repositories;

import org.example.examback.domain.entites.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
