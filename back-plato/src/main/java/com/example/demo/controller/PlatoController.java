package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.PlatoEntity;
import com.example.demo.interfaces.IPlatoService;

@RestController
@RequestMapping("/api/v1/entities/plato")

public class PlatoController{

    @Autowired
    private IPlatoService service;

    @GetMapping("/")
    public List<PlatoEntity> listar() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlatoEntity> buscarPorId(@PathVariable Long id) {
        PlatoEntity plato = service.findById(id);
        if (plato != null) {
            return new ResponseEntity<>(plato, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<PlatoEntity> crear(@RequestBody PlatoEntity plato) {
        System.out.println("Capa Rest recibió: " + plato.getNombre()); 
        PlatoEntity nuevoPlato = service.save(plato);
        return new ResponseEntity<>(nuevoPlato, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<PlatoEntity> actualizar(@PathVariable Long id, @RequestBody PlatoEntity plato) {
        PlatoEntity platoExistente = service.findById(id);
        if (platoExistente != null) {
            platoExistente.setNombre(plato.getNombre());
            PlatoEntity platoActualizado = service.save(platoExistente);
            return new ResponseEntity<>(platoActualizado, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}