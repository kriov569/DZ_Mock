package ru.productstar.outcoming.service;

import org.springframework.stereotype.Service;
import ru.productstar.outcoming.model.Client;
import ru.productstar.outcoming.repository.ClientRepository;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository repo;

    public ClientService(ClientRepository repo) {
        this.repo = repo;
    }

    public void addClient(String name) {
        Client c = new Client();
        c.setName(name);
        repo.save(c);
    }

    public List<Client> getAllClients() {
        return repo.findAll();
    }
}
