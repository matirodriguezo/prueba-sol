package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PlatoEntity;
import com.example.demo.repository.PlatoRepository;
import com.example.demo.interfaces.IPlatoService; 

@Service
public class PlatoServiceImpl implements IPlatoService {

    @Autowired
    private PlatoRepository repository;

    @Override
    public List<PlatoEntity> findAll() {
        return (List<PlatoEntity>) repository.findAll();
    }

    @Override
    public PlatoEntity findById(Long id) {
        Optional<PlatoEntity> opcional = repository.findById(id);
        return opcional.orElse(null); 
    }

    @Override
    public PlatoEntity save(PlatoEntity plato) {
        return repository.save(plato); 
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}