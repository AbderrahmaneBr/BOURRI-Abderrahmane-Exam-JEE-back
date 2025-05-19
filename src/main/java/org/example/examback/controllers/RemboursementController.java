package org.example.examback.controllers;

import lombok.RequiredArgsConstructor;
import org.example.examback.dto.RemboursementDTO;
import org.example.examback.services.RembousementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/remboursements")
@RequiredArgsConstructor
@CrossOrigin("*")
public class RemboursementController {

    private final RembousementService rembousementService;

    @GetMapping
    public List<RemboursementDTO> getAllRemboursements() {
        return rembousementService.getRemboursements();
    }

    @GetMapping("/{id}")
    public RemboursementDTO getRemboursementById(@PathVariable int id) {
        return rembousementService.getRemboursementById(id);
    }

    @PostMapping("/{creditId}")
    public RemboursementDTO addRemboursement(@RequestBody RemboursementDTO remb, @PathVariable long creditId) {
        return rembousementService.addRemboursement(remb, creditId);
    }

    @PutMapping("/{creditId}")
    public RemboursementDTO updateRemboursement(@RequestBody RemboursementDTO remb, @PathVariable long creditId) {
        return rembousementService.updateRemboursement(remb, creditId);
    }

    @DeleteMapping("/{id}")
    public void deleteRemboursement(@PathVariable int id) {
        rembousementService.deleteRemboursement(id);
    }
}