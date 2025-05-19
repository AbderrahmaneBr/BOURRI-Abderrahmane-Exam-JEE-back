package org.example.examback.controllers;

import lombok.RequiredArgsConstructor;
import org.example.examback.dto.*;
import org.example.examback.services.CreditService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/credits")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CreditController {

    private final CreditService creditService;

    @GetMapping
    public List<CreditDTO> getAllCredits() {
        return creditService.getCredits();
    }

    @GetMapping("/{id}")
    public CreditDTO getCreditById(@PathVariable Long id) {
        return creditService.getCreditById(id);
    }

    @GetMapping("/client/{clientId}")
    public CreditDTO getCreditByClientId(@PathVariable Long clientId) {
        return creditService.getCreditByClientId(clientId);
    }

    @PostMapping("/immobilier/{clientId}")
    public CreditDTO addImmobilierCredit(@RequestBody CreditImmobilierDTO creditDTO, @PathVariable Long clientId) {
        return creditService.addCreditImmobilier(creditDTO, clientId);
    }

    @PostMapping("/personnel/{clientId}")
    public CreditDTO addPersonnelCredit(@RequestBody CreditPersonnelDTO creditDTO, @PathVariable Long clientId) {
        return creditService.addCreditPersonnel(creditDTO, clientId);
    }

    @PostMapping("/professionnel/{clientId}")
    public CreditDTO addProfessionnelCredit(@RequestBody CreditProfessionnelDTO creditDTO, @PathVariable Long clientId) {
        return creditService.addCreditProfessionnel(creditDTO, clientId);
    }

    @DeleteMapping("/{id}")
    public void deleteCredit(@PathVariable Long id) {
        creditService.deleteCredit(id);
    }

    @GetMapping("/{creditId}/remboursements")
    public List<RemboursementDTO> getCreditRemboursements(@PathVariable Long creditId) {
        return creditService.getCreditRemboursements(creditId);
    }
}
