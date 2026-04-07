package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "buses")
@Data                
@NoArgsConstructor    
@AllArgsConstructor   
public class BusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String patente;
    private String marca;
    private Double km;
    private int anio;
    private char combustible;
    private boolean revisionAlDia;
}