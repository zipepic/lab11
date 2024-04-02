package com.example.lab11.service;

import com.example.lab11.model.Client;
import com.example.lab11.repo.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

//    public List<Client> getAllClients() {
//        return clientRepository.findAll();
//    }
    public Page<Client> getAllClients(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }

    public Page<Client> searchClients(String keyword, Pageable pageable) {
        return clientRepository.findByFirstNameContainingIgnoreCase(keyword, pageable);
    }

    public Client getClientById(int id) {
        return clientRepository.findById(id).orElse(null);
    }

    public void addClient(Client client) {
        clientRepository.save(client);
    }

    public void updateClient(int id, Client client) {
        Client existingClient = clientRepository.findById(id).orElse(null);
        if (existingClient != null) {
            client.setID(id);
            clientRepository.save(client);
        }
    }
    public void addBal(int clientId, int price){
        var client = clientRepository.findById(clientId);
        client.get().setBal(client.get().getBal()+price);
    }
    public void deleteClient(int id) {
        clientRepository.deleteById(id);
    }
}

