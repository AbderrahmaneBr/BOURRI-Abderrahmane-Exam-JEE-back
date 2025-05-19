package org.example.examback.services;

import org.example.examback.dto.*;

import java.util.List;

public interface CreditService {
    List<CreditDTO> getCredits();
    CreditDTO getCreditById(long creditId);
    CreditDTO getCreditByClientId(long clientId);
    CreditDTO addCreditImmobilier(CreditImmobilierDTO creditDTO, long clientId);
    CreditDTO addCreditPersonnel(CreditPersonnelDTO creditDTO, long clientId);
    CreditDTO addCreditProfessionnel(CreditProfessionnelDTO creditDTO, long clientId);
    void deleteCredit(long creditId);
    List<RemboursementDTO> getCreditRemboursements(long creditId);
}
