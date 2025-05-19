package org.example.examback.services;

import org.example.examback.dto.ClientDTO;
import org.example.examback.dto.CreditDTO;

import java.util.List;

public interface ClientService {
    List<ClientDTO> getClients();
    ClientDTO getClientById(long id);
    ClientDTO addClient(ClientDTO clientDTO);
    ClientDTO updateClient(ClientDTO clientDTO);
    void deleteClientById(long id);
    List<CreditDTO> getClientCredits(long clientId);
}
