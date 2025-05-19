package org.example.examback.services.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.examback.domain.entites.Credit;
import org.example.examback.domain.entites.Remboursement;
import org.example.examback.domain.mappers.dtoMapper;
import org.example.examback.domain.repositories.CreditRepository;
import org.example.examback.domain.repositories.RemboursementRepository;
import org.example.examback.dto.RemboursementDTO;
import org.example.examback.exceptions.ClientNotFoundException;
import org.example.examback.exceptions.CreditNotFountException;
import org.example.examback.exceptions.RemboursementNotFound;
import org.example.examback.services.RembousementService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class RembousementServiceImpl implements RembousementService {

    private RemboursementRepository remboursementRepository;

    private CreditRepository creditRepository;

    private dtoMapper mapper;

    @Override
    public List<RemboursementDTO> getRemboursements() {
        return remboursementRepository.findAll()
                .stream()
                .map(mapper::fromRemboursement)
                .collect(Collectors.toList());
    }

    @Override
    public RemboursementDTO getRemboursementById(int id) {
        Remboursement remboursement = remboursementRepository.findById((long) id)
                .orElseThrow(RemboursementNotFound::new);
        return mapper.fromRemboursement(remboursement);
    }

    @Override
    public RemboursementDTO addRemboursement(RemboursementDTO remb, long creditId) {
        Credit credit = creditRepository.findById(creditId)
                .orElseThrow(ClientNotFoundException::new);
        Remboursement remboursement = mapper.fromRemboursementDTO(remb);
        remboursement.setCredit(credit);
        Remboursement saved = remboursementRepository.save(remboursement);
        return mapper.fromRemboursement(saved);
    }

    @Override
    public void deleteRemboursement(int id) {
        if (!remboursementRepository.existsById((long) id)) {
            throw new RemboursementNotFound();
        }
        remboursementRepository.deleteById((long) id);
    }

    @Override
    public RemboursementDTO updateRemboursement(RemboursementDTO remb, long creditId) {
        Remboursement existing = remboursementRepository.findById(remb.getId())
                .orElseThrow(RemboursementNotFound::new);

        Credit credit = creditRepository.findById(creditId)
                .orElseThrow(CreditNotFountException::new);

        Remboursement updated = mapper.fromRemboursementDTO(remb);
        updated.setCredit(credit);
        updated.setId(existing.getId());

        Remboursement saved = remboursementRepository.save(updated);
        return mapper.fromRemboursement(saved);
    }
}
