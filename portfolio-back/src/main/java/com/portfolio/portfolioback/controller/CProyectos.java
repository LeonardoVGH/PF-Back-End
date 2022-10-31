/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolioback.controller;

/**
 *
 * @author Leo
 */

import com.portfolio.portfolioback.DTO.dtoProyectos;
import com.portfolio.portfolioback.Entity.Proyectos;
import com.portfolio.portfolioback.Servicio.SProyectos;

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
@RequestMapping("/proyectos")
@CrossOrigin(origins = {"http://localhost:4200", "https://portolioargprofront.web.app"})
//@CrossOrigin(origins = "https://.web.app")
public class CProyectos {

    @Autowired
    SProyectos sProyectos;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list(){
        List<Proyectos> list = sProyectos.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id){
        if(!sProyectos.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Proyectos proyectos = sProyectos.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sProyectos.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe el id de Proyectos que se intento eliminar"), HttpStatus.NOT_FOUND);
        }
        sProyectos.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminada"), HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyectos dtoexp){    
        
        
        /**if(StringUtils.isBlank(dtoexp.getexptitulo()))
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST); **/
        
        
        if(sProyectos.existsBynombre(dtoexp.getNombre()))
            return new ResponseEntity(new Mensaje("ya existe un Proyecto con ese titulo"), HttpStatus.BAD_REQUEST);
        
       Proyectos proyectos = new Proyectos(dtoexp.getNombre(), dtoexp.getDescripcion(), dtoexp.getLogo());
        sProyectos.save(proyectos);
        
        return new ResponseEntity(new Mensaje("Proyecto agregado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyectos dtoexp){
        //Valida si existe el ID
        if(!sProyectos.existsById(id))
            return new ResponseEntity(new Mensaje("El ID de Proyectos que se intenta actualizar no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(sProyectos.existsBynombre(dtoexp.getNombre()) && sProyectos.getBynombre(dtoexp.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Ese Proyectos ya existe mr simpsons"), HttpStatus.BAD_REQUEST);
        
/*
        if(StringUtils.isBlank(dtoexp.getexptitulo()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST); */
        
        Proyectos proyectos = sProyectos.getOne(id).get();
        
        proyectos.setNombre(dtoexp.getNombre());
        proyectos.setDescripcion(dtoexp.getDescripcion());
        proyectos.setLogo(dtoexp.getLogo());

        
        sProyectos.save(proyectos);
        return new ResponseEntity(new Mensaje("proyectos actualizados"), HttpStatus.OK);
             
    }
}
