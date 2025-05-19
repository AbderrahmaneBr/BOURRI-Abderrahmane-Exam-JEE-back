package org.example.examback.services;

import org.example.examback.dto.RemboursementDTO;

import java.util.List;

public interface RembousementService {
    List<RemboursementDTO> getRemboursements();
    RemboursementDTO getRemboursementById(int id);
    RemboursementDTO addRemboursement(RemboursementDTO remb, long creditId);
    void deleteRemboursement(int id);
    RemboursementDTO updateRemboursement(RemboursementDTO remb, long creditId);
}
