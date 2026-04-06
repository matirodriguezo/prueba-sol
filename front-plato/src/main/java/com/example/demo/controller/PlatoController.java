package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.PlatoEntity;
import com.example.demo.interfaces.IPlatoService;

@Controller
@RequestMapping("crud/plato")
public class PlatoController {

    @Autowired
    private IPlatoService service;

    // 1. READ
    @GetMapping("/")
    public String plato(Model model) {
        List<PlatoEntity> platos = service.findAll();
        model.addAttribute("platos", platos);
        return "index";
    }

    // 2. CREATE
    @GetMapping("/formulario")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("platos", new PlatoEntity());
        return "formulario";
    }

    // 3. UPDATE
    @GetMapping("/formulario/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        PlatoEntity plato = service.findById(id);
        model.addAttribute("plato", plato);
        return "formulario";
    }

    // 4. CREATE / UPDATE
    @PostMapping("/save")
    public String guardarPlato(@ModelAttribute("plato") PlatoEntity plato) {
        
        System.out.println("Frontend recibe desde HTML: ID=" + plato.getId() + ", Nombre=" + plato.getNombre());
        
        service.save(plato);
        return "redirect:/crud/plato/";
    }

    // 5. DELETE
    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/crud/plato/";
    }
}