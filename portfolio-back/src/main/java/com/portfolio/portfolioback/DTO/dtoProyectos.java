/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolioback.DTO;

/**
 *
 * @author Leo
 */

import javax.validation.constraints.NotBlank;

public class dtoProyectos {
    
   @NotBlank 
   private String nombre;
   @NotBlank
   private String descripcion;
   @NotBlank
   private String logo;

    public dtoProyectos(String nombre, String descripcion, String logo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.logo = logo;
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
