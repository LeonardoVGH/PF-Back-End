/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolioback.controller;

/**
 *
 * @author Leo
 */

import com.portfolio.portfolioback.DTO.dtoEducacion;
import com.portfolio.portfolioback.Entity.Educacion;
import com.portfolio.portfolioback.Servicio.SEducacion;

import com.portfolio.portfolioback.Security.Controller.Mensaje;
import java.util.List;
/*import org.apache.commons.lang3.StringUtils;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/educacion")
@CrossOrigin(origins = {"http://localhost:4200", "https://portolioargprofront.web.app"})
//@CrossOrigin(origins = "https://.web.app")
public class CEducacion {

    @Autowired
    SEducacion sEducacion;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = sEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!sEducacion.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Educacion educacion = sEducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe el id de Educacion que se intento eliminar"), HttpStatus.NOT_FOUND);
        }
        sEducacion.delete(id);
        return new ResponseEntity(new Mensaje("educacion eliminada"), HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoexp){    
        
         
        
        if(sEducacion.existsBygrado(dtoexp.getGrado()))
            return new ResponseEntity(new Mensaje("ya existe una Educacion con ese titulo"), HttpStatus.BAD_REQUEST);
        
        Educacion educacion = new Educacion(dtoexp.getGrado(), dtoexp.getEscuela(), dtoexp.getIngreso(), dtoexp.getEgreso(), dtoexp.getDescripcion(), dtoexp.getLogo());
        sEducacion.save(educacion);
        
        return new ResponseEntity(new Mensaje("Educacion agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoeduca){
        //Valida si existe el ID
        if(!sEducacion.existsById(id))
            return new ResponseEntity(new Mensaje("El ID de Educacion que se intenta actualizar no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de los campos
        if(sEducacion.existsBygrado(dtoeduca.getGrado()) && sEducacion.getBygrado(dtoeduca.getGrado()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa educacion ya fue cargada"), HttpStatus.BAD_REQUEST);
        
/*
        if(StringUtils.isBlank(dtoexp.getexptitulo()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST); */
        
        Educacion educacion = sEducacion.getOne(id).get();
        
        educacion.setGrado(dtoeduca.getGrado());
        educacion.setEscuela(dtoeduca.getEscuela());
        educacion.setIngreso(dtoeduca.getIngreso());
        educacion.setEgreso(dtoeduca.getEgreso());
        educacion.setDescripcion(dtoeduca.getDescripcion());
        educacion.setLogo(dtoeduca.getLogo());

        
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("educacion actualizada"), HttpStatus.OK);
             
    }
}
