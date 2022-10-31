/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolioback.DTO;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Leo
 */
public class dtoAbout {
    
    @NotBlank
    private String nombre;
    @NotBlank
    private String titulo;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String url_img;
    @NotBlank
    private String url_banner;

    public dtoAbout(String nombre, String titulo, String descripcion, String url_img, String url_banner) {
        this.nombre = nombre;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.url_img = url_img;
        this.url_banner = url_banner;
    }

    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl_img() {
        return url_img;
    }

    public void setUrl_img(String url_img) {
        this.url_img = url_img;
    }

    public String getUrl_banner() {
        return url_banner;
    }

    public void setUrl_banner(String url_banner) {
        this.url_banner = url_banner;
    }
    
    
    
}
