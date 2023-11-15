package com.manou.location.services;

import com.manou.location.models.Client;
import com.manou.location.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    //update
    public Optional<Client> getClient(int id) {
        return clientRepository.findById(id);
    }

    //read
    public Iterable<Client> getClients() {
        return clientRepository.findAll();
    }

    //delete
    public void deleteClient(int id) {
        clientRepository.deleteById(id);
    }

    //create
    public Client saveClient(Client client) {
        Client savedClient = clientRepository.save(client);
        return savedClient;
    }
}
