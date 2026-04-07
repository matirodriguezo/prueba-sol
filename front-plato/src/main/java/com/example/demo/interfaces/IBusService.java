package com.example.demo.interfaces;

import java.util.List;

import com.example.demo.entity.BusEntity;

public interface IBusService {
	List<BusEntity> findAll();
	BusEntity findById(Long id);
	BusEntity save (BusEntity plato);
	void deleteById(Long id);
	
}
