/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolioback.controller;

/**
 *
 * @author Leo
 */
import com.portfolio.portfolioback.DTO.dtoExperiencia;
import com.portfolio.portfolioback.Entity.Experiencia;
import com.portfolio.portfolioback.Servicio.SExperiencia;

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
@RequestMapping("/explab")
@CrossOrigin(origins = {"http://localhost:4200", "https://portolioargprofront.web.app"})
//@CrossOrigin(origins = "https://.web.app")
public class CExperiencia {
    @Autowired
    SExperiencia sExperiencia;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = sExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!sExperiencia.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = sExperiencia.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe el id de experiencia que se intento eliminar"), HttpStatus.NOT_FOUND);
        }
        sExperiencia.delete(id);
        return new ResponseEntity(new Mensaje("experiencia eliminada"), HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoexp){    
        
        
        /**if(StringUtils.isBlank(dtoexp.getexptitulo()))
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST); **/
        
        
        if(sExperiencia.existsByexptitulo(dtoexp.getexptitulo()))
            return new ResponseEntity(new Mensaje("ya existe una experiencia con ese titulo"), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = new Experiencia(dtoexp.getexptitulo(), dtoexp.getExp_empresa(), dtoexp.getExp_desde(), dtoexp.getExp_hasta(), dtoexp.getExp_descripcion(), dtoexp.getLogo());
        sExperiencia.save(experiencia);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperiencia dtoexp){
        //Valida si existe el ID
        if(!sExperiencia.existsById(id))
            return new ResponseEntity(new Mensaje("El ID de experiencia que se intenta actualizar no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(sExperiencia.existsByexptitulo(dtoexp.getexptitulo()) && sExperiencia.getByexptitulo(dtoexp.getexptitulo()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        
/*
        if(StringUtils.isBlank(dtoexp.getexptitulo()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST); */
        
        Experiencia experiencia = sExperiencia.getOne(id).get();
        
        experiencia.setexptitulo(dtoexp.getexptitulo());
        experiencia.setExp_empresa(dtoexp.getExp_empresa());
        experiencia.setExp_desde(dtoexp.getExp_desde());
        experiencia.setExp_hasta(dtoexp.getExp_hasta());
        experiencia.setExp_descripcion(dtoexp.getExp_descripcion());
        experiencia.setLogo(dtoexp.getLogo());
        
        sExperiencia.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
             
    }
}