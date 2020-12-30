package com.db.coursework.services;

import com.db.coursework.entities.Client;
import com.db.coursework.repo.ClientRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientService {
    private final ClientRepository repository;

    @Autowired
    public ClientService(ClientRepository repository){
        this.repository = repository;
    }

    @Transactional
    public List<Client> findAll() {
        return repository.findAll();
    }

    @Transactional
    public Client saveClient(Client client) {
        return repository.save(client);
    }

    @Transactional
    public Client getByToken(String clientToken) throws NotFoundException {
        Optional<Client> client = repository.findById(clientToken);
        if(client.isPresent())
            return client.get();
        else
            throw new NotFoundException("Client does not exist");
    }
}
