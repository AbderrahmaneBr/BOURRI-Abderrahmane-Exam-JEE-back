package org.example.examback.domain.mappers;


import org.example.examback.domain.entites.*;
import org.example.examback.dto.*;
import org.springframework.beans.BeanUtils;

import java.util.List;

public class dtoMapper {

    public ClientDTO fromClient(Client client) {
        ClientDTO clientDTO = new ClientDTO();
        BeanUtils.copyProperties(client, clientDTO);
        if (client.getCredits() != null) {
            List<CreditDTO> creditDTOS = client.getCredits().stream().map(this::fromCredit).toList();
            clientDTO.setCredits(creditDTOS);
        }
        return clientDTO;
    }

    public Client fromClientDTO(ClientDTO clientDTO) {
        Client client = new Client();
        BeanUtils.copyProperties(clientDTO, client);
        if (clientDTO.getCredits() != null) {
            List<Credit> credits = clientDTO.getCredits().stream().map(this::fromCreditDTO).toList();
            client.setCredits(credits);
        }
        return client;
    }

    public CreditDTO fromCredit(Credit credit) {
        if (credit instanceof CreditImmobilier) {
            return fromCreditImmobilier((CreditImmobilier) credit);
        } else if (credit instanceof CreditPersonnel) {
            return fromCreditPersonnel((CreditPersonnel) credit);
        } else if (credit instanceof CreditProfessionnel) {
            return fromCreditProfessionnel((CreditProfessionnel) credit);
        }
        return null;
    }

    public Credit fromCreditDTO(CreditDTO creditDTO) {
        if (creditDTO instanceof CreditImmobilierDTO) {
            return fromCreditImmobilierDTO((CreditImmobilierDTO) creditDTO);
        } else if (creditDTO instanceof CreditPersonnelDTO) {
            return fromCreditPersonnelDTO((CreditPersonnelDTO) creditDTO);
        } else if (creditDTO instanceof CreditProfessionnelDTO) {
            return fromCreditProfessionnelDTO((CreditProfessionnelDTO) creditDTO);
        }
        return null;
    }

    public CreditImmobilierDTO fromCreditImmobilier(CreditImmobilier credit) {
        CreditImmobilierDTO dto = new CreditImmobilierDTO();
        BeanUtils.copyProperties(credit, dto);
        dto.setClient(fromClient(credit.getClient()));
        if (credit.getRemboursements() != null) {
            dto.setRemboursements(credit.getRemboursements().stream().map(this::fromRemboursement).toList());
        }
        return dto;
    }

    public CreditImmobilier fromCreditImmobilierDTO(CreditImmobilierDTO dto) {
        CreditImmobilier credit = new CreditImmobilier();
        BeanUtils.copyProperties(dto, credit);
        credit.setClient(fromClientDTO(dto.getClient()));
        if (dto.getRemboursements() != null) {
            credit.setRemboursements(dto.getRemboursements().stream().map(this::fromRemboursementDTO).toList());
        }
        return credit;
    }

    public CreditPersonnelDTO fromCreditPersonnel(CreditPersonnel credit) {
        CreditPersonnelDTO dto = new CreditPersonnelDTO();
        BeanUtils.copyProperties(credit, dto);
        dto.setClient(fromClient(credit.getClient()));
        if (credit.getRemboursements() != null) {
            dto.setRemboursements(credit.getRemboursements().stream().map(this::fromRemboursement).toList());
        }
        return dto;
    }

    public CreditPersonnel fromCreditPersonnelDTO(CreditPersonnelDTO dto) {
        CreditPersonnel credit = new CreditPersonnel();
        BeanUtils.copyProperties(dto, credit);
        credit.setClient(fromClientDTO(dto.getClient()));
        if (dto.getRemboursements() != null) {
            credit.setRemboursements(dto.getRemboursements().stream().map(this::fromRemboursementDTO).toList());
        }
        return credit;
    }

    public CreditProfessionnelDTO fromCreditProfessionnel(CreditProfessionnel credit) {
        CreditProfessionnelDTO dto = new CreditProfessionnelDTO();
        BeanUtils.copyProperties(credit, dto);
        dto.setClient(fromClient(credit.getClient()));
        if (credit.getRemboursements() != null) {
            dto.setRemboursements(credit.getRemboursements().stream().map(this::fromRemboursement).toList());
        }
        return dto;
    }

    public CreditProfessionnel fromCreditProfessionnelDTO(CreditProfessionnelDTO dto) {
        CreditProfessionnel credit = new CreditProfessionnel();
        BeanUtils.copyProperties(dto, credit);
        credit.setClient(fromClientDTO(dto.getClient()));
        if (dto.getRemboursements() != null) {
            credit.setRemboursements(dto.getRemboursements().stream().map(this::fromRemboursementDTO).toList());
        }
        return credit;
    }

    public RemboursementDTO fromRemboursement(Remboursement remboursement) {
        RemboursementDTO dto = new RemboursementDTO();
        BeanUtils.copyProperties(remboursement, dto);
        dto.setCredit(fromCredit(remboursement.getCredit()));
        return dto;
    }

    public Remboursement fromRemboursementDTO(RemboursementDTO dto) {
        Remboursement remboursement = new Remboursement();
        BeanUtils.copyProperties(dto, remboursement);
        remboursement.setCredit(fromCreditDTO(dto.getCredit()));
        return remboursement;
    }
}
