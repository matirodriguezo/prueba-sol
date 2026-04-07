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

import com.example.demo.entity.BusEntity;
import com.example.demo.interfaces.IBusService;

@Controller
@RequestMapping("crud/bus")
public class BusController {

    @Autowired
    private IBusService service;

    // 1. READ
    @GetMapping("/")
    public String bus(Model model) {
        List<BusEntity> buses = service.findAll();
        model.addAttribute("buses", buses);
        return "index";
    }

    // 2. CREATE
    @GetMapping("/formulario")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("bus", new BusEntity());
        return "formulario";
    }

    // 3. UPDATE
    @GetMapping("/formulario/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        BusEntity bus = service.findById(id);
        model.addAttribute("bus", bus);
        return "formulario";
    }

    // 4. CREATE / UPDATE
    @PostMapping("/save")
    public String guardarBus(@ModelAttribute("bus") BusEntity bus) {
        
        System.out.println("Frontend recibe desde HTML: ID=" + bus.getId() + ", Patente=" + bus.getPatente());
        
        service.save(bus);
        return "redirect:/crud/bus/";
    }

    // 5. DELETE
    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/crud/bus/";
    }
}