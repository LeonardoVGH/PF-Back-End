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

public class dtoEducacion {
    
   @NotBlank 
   private String grado;
   @NotBlank
   private String escuela;
   @NotBlank
   private String ingreso;
   @NotBlank
   private String egreso;
   @NotBlank
   private String descripcion;
   @NotBlank
   private String logo;

    public dtoEducacion(String grado, String escuela, String ingreso, String egreso, String descripcion, String logo) {
        this.grado = grado;
        this.escuela = escuela;
        this.ingreso = ingreso;
        this.egreso = egreso;
        this.descripcion = descripcion;
        this.logo = logo;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }

    public String getIngreso() {
        return ingreso;
    }

    public void setIngreso(String ingreso) {
        this.ingreso = ingreso;
    }

    public String getEgreso() {
        return egreso;
    }

    public void setEgreso(String egreso) {
        this.egreso = egreso;
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
