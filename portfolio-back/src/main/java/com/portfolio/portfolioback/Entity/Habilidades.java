/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolioback.Entity;

/**
 *
 * @author Leo
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Habilidades {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)  
   private int id;
   
   private String nombre;
   private int porcentual;

    public Habilidades(String nombre, int porcentual) {
        this.nombre = nombre;
        this.porcentual = porcentual;
    }

    
        public Habilidades() {
    }
        
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPorcentual() {
        return porcentual;
    }

    public void setPorcentual(int porcentual) {
        this.porcentual = porcentual;
    }
   
   
}
