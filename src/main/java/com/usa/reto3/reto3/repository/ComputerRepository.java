package com.usa.reto3.reto3.repository;

import com.usa.reto3.reto3.entities.Computer;
import com.usa.reto3.reto3.repository.crudRepository.ComputerCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ComputerRepository {
    @Autowired
    private ComputerCrudRepository computerCrudRespository;

    public List<Computer> getAll(){
        return (List<Computer>) computerCrudRespository.findAll();
    }
    public Optional<Computer> getComputer(int id){
        return computerCrudRespository.findById(id);
    }
    public Computer save(Computer c){
        return computerCrudRespository.save(c);
    }
    public void delete(Computer c){
        computerCrudRespository.delete(c);
    }
}
