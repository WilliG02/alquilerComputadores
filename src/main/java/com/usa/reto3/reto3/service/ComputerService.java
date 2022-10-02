package com.usa.reto3.reto3.service;


import com.usa.reto3.reto3.entities.Computer;
import com.usa.reto3.reto3.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComputerService {
    @Autowired
    private ComputerRepository computerRepository;

    public List<Computer> getAll(){
        return computerRepository.getAll();
    }

    public Optional<Computer> getComputer(int id){
        return computerRepository.getComputer(id);
    }

    public Computer save(Computer p){
        if(p.getId() == null){
            return computerRepository.save(p);
        }else{
            Optional<Computer> e = computerRepository.getComputer(p.getId());
            if(e.isPresent()){
                return p;
            }else{
                return computerRepository.save(p);
            }
        }
    }
    public Computer update(Computer p){
        if(p.getId() != null){
            Optional<Computer> q = computerRepository.getComputer(p.getId());
            if(q.isPresent()){
                if(p.getName() != null) {
                    q.get().setName(p.getName());
                }
                if(p.getBrand() != null) {
                    q.get().setBrand(p.getBrand());
                }
                if(p.getYear() != null) {
                    q.get().setYear(p.getYear());
                }
                if(p.getDescription() != null) {
                    q.get().setDescription(p.getDescription());
                }
                computerRepository.save(q.get());
                return q.get();
            }else{
                return p;
            }
        }else{
            return  p;
        }
    }

    public boolean delete(int id) {
        boolean flag = false;
        Optional<Computer> p = computerRepository.getComputer(id);
        if (p.isPresent()) {
            computerRepository.delete(p.get());
            flag = true;
        }
        return flag;
    }
}
