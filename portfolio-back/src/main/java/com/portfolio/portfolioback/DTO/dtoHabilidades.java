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

public class dtoHabilidades {
    
   @NotBlank 
   private String nombre;
   @NotBlank
   private int porcentual;

    public dtoHabilidades(String nombre, int porcentual) {
        this.nombre = nombre;
        this.porcentual = porcentual;
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
