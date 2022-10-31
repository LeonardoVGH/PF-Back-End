/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolioback.controller;

/**
 *
 * @author Leo
 */

import com.portfolio.portfolioback.DTO.dtoHabilidades;
import com.portfolio.portfolioback.Entity.Habilidades;
import com.portfolio.portfolioback.Servicio.SHabilidades;

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
@RequestMapping("/habilidades")
@CrossOrigin(origins = {"http://localhost:4200", "https://portolioargprofront.web.app"})
//@CrossOrigin(origins = "https://.web.app")
public class CHabilidades {
   @Autowired
   SHabilidades sHabilidades;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Habilidades>> list(){
        List<Habilidades> list = sHabilidades.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Habilidades> getById(@PathVariable("id") int id){
        if(!sHabilidades.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Habilidades habilidades = sHabilidades.getOne(id).get();
        return new ResponseEntity(habilidades, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sHabilidades.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe el id de Habilidades que se intento eliminar"), HttpStatus.NOT_FOUND);
        }
        sHabilidades.delete(id);
        return new ResponseEntity(new Mensaje("Habilidad eliminada"), HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHabilidades dtoexp){    
        
        
              
        
        if(sHabilidades.existsBynombre(dtoexp.getNombre()))
            return new ResponseEntity(new Mensaje("ya existe una Habilidad con ese titulo"), HttpStatus.BAD_REQUEST);
        
        Habilidades habilidades = new Habilidades(dtoexp.getNombre(), dtoexp.getPorcentual());
        sHabilidades.save(habilidades);
        
        return new ResponseEntity(new Mensaje("Habilidades actualizado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHabilidades dtoexp){
        //Valida si existe el ID
        if(!sHabilidades.existsById(id))
            return new ResponseEntity(new Mensaje("El ID de Habilidades que se intenta actualizar no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de Habilidades
        if(sHabilidades.existsBynombre(dtoexp.getNombre()) && sHabilidades.getBynombre(dtoexp.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa Habilidad ya existe"), HttpStatus.BAD_REQUEST);
        
/*
        if(StringUtils.isBlank(dtoexp.getexptitulo()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST); */
        
        Habilidades habilidades = sHabilidades.getOne(id).get();
        
       habilidades.setNombre(dtoexp.getNombre());
       habilidades.setPorcentual(dtoexp.getPorcentual());
        
        sHabilidades.save(habilidades);
        return new ResponseEntity(new Mensaje("Habilidades actualizado"), HttpStatus.OK);
             
    } 
}
