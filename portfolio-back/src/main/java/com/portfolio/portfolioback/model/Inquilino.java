
package com.portfolio.portfolioback.model;


public class Inquilino {
  
    private Long id_inquilino;
    private String dni;
    private String nombre;
    private String apellido;
    private String profesion;

    public Inquilino(Long id_inquilino, String dni, String nombre, String apellido, String profesion) {
        this.id_inquilino = id_inquilino;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.profesion = profesion;
    }

    

}
