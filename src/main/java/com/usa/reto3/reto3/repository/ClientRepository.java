package com.usa.reto3.reto3.repository;


import com.usa.reto3.reto3.entities.Client;
import com.usa.reto3.reto3.repository.crudRepository.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {
    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<Client> getAll(){
        return (List<Client>) clientCrudRepository.findAll();
    }
    //Encuentra el producto
    public Optional<Client> getClient(int idClient){
        return clientCrudRepository.findById(idClient);
    }
    // lo guarda
    public Client save(Client c){
        return clientCrudRepository.save(c);
    }
    // lo borra
    public void delete(Client p){
        clientCrudRepository.delete(p);
    }
}
