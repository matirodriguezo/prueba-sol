package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BusEntity;
import com.example.demo.repository.BusRepository;
import com.example.demo.interfaces.IBusService; 

@Service
public class BusServiceImpl implements IBusService {

    @Autowired
    private BusRepository repository;

    @Override
    public List<BusEntity> findAll() {
        return (List<BusEntity>) repository.findAll();
    }

    @Override
    public BusEntity findById(Long id) {
        Optional<BusEntity> opcional = repository.findById(id);
        return opcional.orElse(null); 
    }

    @Override
    public BusEntity save(BusEntity bus) {
        return repository.save(bus); 
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}