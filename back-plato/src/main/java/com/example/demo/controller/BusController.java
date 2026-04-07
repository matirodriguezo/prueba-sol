package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.BusEntity;
import com.example.demo.interfaces.IBusService;

@RestController
@RequestMapping("/api/v1/entities/bus")

public class BusController{

    @Autowired
    private IBusService service;

    @GetMapping("/")
    public List<BusEntity> listar() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusEntity> buscarPorId(@PathVariable Long id) {
        BusEntity bus = service.findById(id);
        if (bus != null) {
            return new ResponseEntity<>(bus, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<BusEntity> crear(@RequestBody BusEntity bus) {
        System.out.println("Capa Rest recibió: " + bus.getPatente()); 
        BusEntity nuevobus = service.save(bus);
        return new ResponseEntity<>(nuevobus, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<BusEntity> actualizar(@PathVariable Long id, @RequestBody BusEntity bus) {
        BusEntity busExistente = service.findById(id);
        if (busExistente != null) {
            busExistente.setPatente(bus.getPatente());
            busExistente.setMarca(bus.getMarca());
            busExistente.setKm(bus.getKm());
            busExistente.setAnio(bus.getAnio());
            busExistente.setCombustible(bus.getCombustible());
            busExistente.setRevisionAlDia(bus.isRevisionAlDia());
            BusEntity busActualizado = service.save(busExistente);
            return new ResponseEntity<>(busActualizado, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}