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
public class Proyectos {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)  
   
   private int id;
   
   private String nombre;
   private String descripcion;
   private String logo;

    public Proyectos(String nombre, String descripcion, String logo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.logo = logo;
    }

    
       public Proyectos() {
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
   
   
}
