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
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String exptitulo;
    private String exp_empresa;
    private String exp_desde;
    private String exp_hasta;
    private String exp_descripcion;
    private String logo;

    // Constructor
    
    public Experiencia(String exptitulo, String exp_empresa, String exp_desde, String exp_hasta, String exp_descripcion, String logo) {
        this.exptitulo = exptitulo;
        this.exp_empresa = exp_empresa;
        this.exp_desde = exp_desde;
        this.exp_hasta = exp_hasta;
        this.exp_descripcion = exp_descripcion;
        this.logo = logo;
    }
    
    
    // Getters y Setters

    public Experiencia() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getexptitulo() {
        return exptitulo;
    }

    public void setexptitulo(String exptitulo) {
        this.exptitulo = exptitulo;
    }

    public String getExp_empresa() {
        return exp_empresa;
    }

    public void setExp_empresa(String exp_empresa) {
        this.exp_empresa = exp_empresa;
    }

    public String getExp_desde() {
        return exp_desde;
    }

    public void setExp_desde(String exp_desde) {
        this.exp_desde = exp_desde;
    }

    public String getExp_hasta() {
        return exp_hasta;
    }

    public void setExp_hasta(String exp_hasta) {
        this.exp_hasta = exp_hasta;
    }

    public String getExp_descripcion() {
        return exp_descripcion;
    }

    public void setExp_descripcion(String exp_descripcion) {
        this.exp_descripcion = exp_descripcion;
    }

        public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
    /**
    
     
    public Experiencia(String exptitulo, String descripcionE) {
        this.exptitulo = exptitulo;
        this.descripcionE = descripcionE;
    }
    
    //Getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getexptitulo() {
        return exptitulo;
    }

    public void setexptitulo(String exptitulo) {
        this.exptitulo = exptitulo;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }
      */
    
    
}