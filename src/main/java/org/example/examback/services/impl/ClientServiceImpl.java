package org.example.examback.services.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.examback.domain.entites.Client;
import org.example.examback.domain.mappers.dtoMapper;
import org.example.examback.domain.repositories.ClientRepository;
import org.example.examback.domain.repositories.CreditRepository;
import org.example.examback.dto.ClientDTO;
import org.example.examback.dto.CreditDTO;
import org.example.examback.exceptions.ClientNotFoundException;
import org.example.examback.services.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    private CreditRepository creditRepository;

    private dtoMapper mapper;

    @Override
    public List<ClientDTO> getClients() {
        return clientRepository.findAll()
                .stream()
                .map(mapper::fromClient)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDTO getClientById(long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(ClientNotFoundException::new);
        return mapper.fromClient(client);
    }

    @Override
    public ClientDTO addClient(ClientDTO clientDTO) {
        Client client = mapper.fromClientDTO(clientDTO);
        Client savedClient = clientRepository.save(client);
        return mapper.fromClient(savedClient);
    }

    @Override
    public ClientDTO updateClient(ClientDTO clientDTO) {
        if (clientDTO.getId() == null || !clientRepository.existsById(clientDTO.getId())) {
            throw new ClientNotFoundException();
        }
        Client updatedClient = mapper.fromClientDTO(clientDTO);
        Client savedClient = clientRepository.save(updatedClient);
        return mapper.fromClient(savedClient);
    }

    @Override
    public void deleteClientById(long id) {
        if (!clientRepository.existsById(id)) {
            throw new ClientNotFoundException();
        }
        clientRepository.deleteById(id);
    }

    @Override
    public List<CreditDTO> getClientCredits(long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(ClientNotFoundException::new);

        return client.getCredits()
                .stream()
                .map(mapper::fromCredit)
                .collect(Collectors.toList());
    }
}
