package com.example.demo.interfaces;

import java.util.List;

import com.example.demo.entity.PlatoEntity;

public interface IPlatoService {
	List<PlatoEntity> findAll();
	PlatoEntity findById(Long id);
	PlatoEntity save (PlatoEntity plato);
	void deleteById(Long id);
	
}
