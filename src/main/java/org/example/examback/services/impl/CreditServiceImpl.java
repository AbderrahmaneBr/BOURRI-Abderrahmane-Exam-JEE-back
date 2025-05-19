package org.example.examback.services.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.examback.domain.entites.*;
import org.example.examback.domain.mappers.dtoMapper;
import org.example.examback.domain.repositories.ClientRepository;
import org.example.examback.domain.repositories.CreditRepository;
import org.example.examback.domain.repositories.RemboursementRepository;
import org.example.examback.dto.*;
import org.example.examback.exceptions.ClientNotFoundException;
import org.example.examback.exceptions.CreditNotFountException;
import org.example.examback.services.CreditService;
import org.springframework.stereotype.Service;

import java.util.List;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class CreditServiceImpl implements CreditService {

    private CreditRepository creditRepository;

    private ClientRepository clientRepository;

    private RemboursementRepository remboursementRepository;

    private dtoMapper mapper;

    @Override
    public List<CreditDTO> getCredits() {
        return creditRepository.findAll()
                .stream()
                .map(mapper::fromCredit)
                .collect(Collectors.toList());
    }

    @Override
    public CreditDTO getCreditById(long creditId) {
        Credit credit = creditRepository.findById(creditId)
                .orElseThrow(ClientNotFoundException::new);
        return mapper.fromCredit(credit);
    }

    @Override
    public CreditDTO getCreditByClientId(long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(ClientNotFoundException::new);

        return client.getCredits()
                .stream()
                .findFirst()
                .map(mapper::fromCredit)
                .orElseThrow(CreditNotFountException::new);
    }

    @Override
    public CreditDTO addCreditImmobilier(CreditImmobilierDTO creditDTO, long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(ClientNotFoundException::new);
        CreditImmobilier credit = mapper.fromCreditImmobilierDTO(creditDTO);
        credit.setClient(client);
        Credit saved = creditRepository.save(credit);
        return mapper.fromCredit(saved);
    }

    @Override
    public CreditDTO addCreditPersonnel(CreditPersonnelDTO creditDTO, long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(ClientNotFoundException::new);
        CreditPersonnel credit = mapper.fromCreditPersonnelDTO(creditDTO);
        credit.setClient(client);
        Credit saved = creditRepository.save(credit);
        return mapper.fromCredit(saved);
    }

    @Override
    public CreditDTO addCreditProfessionnel(CreditProfessionnelDTO creditDTO, long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(ClientNotFoundException::new);
        CreditProfessionnel credit = mapper.fromCreditProfessionnelDTO(creditDTO);
        credit.setClient(client);
        Credit saved = creditRepository.save(credit);
        return mapper.fromCredit(saved);
    }

    @Override
    public void deleteCredit(long creditId) {
        if (!creditRepository.existsById(creditId)) {
            throw new CreditNotFountException();
        }
        creditRepository.deleteById(creditId);
    }

    @Override
    public List<RemboursementDTO> getCreditRemboursements(long creditId) {
        Credit credit = creditRepository.findById(creditId)
                .orElseThrow(CreditNotFountException::new);

        return credit.getRemboursements()
                .stream()
                .map(mapper::fromRemboursement)
                .collect(Collectors.toList());
    }
}

