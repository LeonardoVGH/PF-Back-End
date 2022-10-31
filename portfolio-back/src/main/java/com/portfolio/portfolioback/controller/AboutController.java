
package com.portfolio.portfolioback.controller;

import com.portfolio.portfolioback.DTO.dtoAbout;
import com.portfolio.portfolioback.Entity.About;
import com.portfolio.portfolioback.Entity.Experiencia;
import com.portfolio.portfolioback.Interfase.About_interfase_servicio;
import com.portfolio.portfolioback.Security.Controller.Mensaje;
import com.portfolio.portfolioback.Servicio.SAbout;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Leo
 */

@RestController
@CrossOrigin (origins = {"http://localhost:4200", "https://portolioargprofront.web.app"})
public class AboutController {
    @Autowired About_interfase_servicio about_interfase_servicio;
    @Autowired
    SAbout sAbout;
    
    @GetMapping("/about/traer")    
    public List<About> getAbout() {
    return about_interfase_servicio.getAbout();
    }
    
    /**
 *
 * aca se podria agregar @preAuthorize ("hasrole(´admin´)") para filtrar actividades permitidaS X rol
 */
    @PostMapping("/about/crear")    
    public String createAbout(@RequestBody About about){
    about_interfase_servicio.saveAbout(about);
    return "Datos grabados";
    }
   
    @DeleteMapping("/about/eliminar/{id}") 
    public String deleteAbout(@PathVariable Long id) {
        about_interfase_servicio.deleteAbout(id); 
        return "Datos eliminados";
    }
    
    @PutMapping("/about/modificar")
     public ResponseEntity<?> update(@RequestBody dtoAbout dtoabout){
        //Validamos si existe el ID
        //if(!sExperiencia.existsById(id))
        //    return new ResponseEntity(new Mensaje("El ID de experiencia que se intenta actualizar no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        //if(sExperiencia.existsByexptitulo(dtoexp.getexptitulo()) && sExperiencia.getByexptitulo(dtoexp.getexptitulo()).get().getId() != id)
        //    return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        
/*
        if(StringUtils.isBlank(dtoexp.getexptitulo()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST); */
        
        About about = sAbout.getOne((long)1).get();
        
        about.setNombre(dtoabout.getNombre());
        about.setTitulo(dtoabout.getTitulo());
        about.setDescripcion(dtoabout.getDescripcion());
        about.setUrl_img(dtoabout.getUrl_img());
        about.setUrl_banner(dtoabout.getUrl_banner());
        
        sAbout.save(about);
        return new ResponseEntity(new Mensaje("About actualizado"), HttpStatus.OK);
    /**
    public About editAbout(@PathVariable Long id,
                           @RequestParam("nombre") String nuevoNombre,
                           @RequestParam("titulo") String nuevoTitulo,
                           @RequestParam("descripcion") String nuevoDescripcion,
                           @RequestParam("url_img") String nuevoUrl_img,
                           @RequestParam("url_banner") String nuevoUrl_banner
                           ) {
    About about = about_interfase_servicio.findAbout(id);
    about.setNombre(nuevoNombre);
    about.setTitulo(nuevoTitulo);
    about.setDescripcion(nuevoDescripcion);
    about.setUrl_img(nuevoUrl_img);
    about.setUrl_banner(nuevoUrl_banner);
    about_interfase_servicio.saveAbout(about);
    return about;
    **/
    
    }
    
    @GetMapping("/about/traer/perfil")
    public About findAbout() {
    return about_interfase_servicio.findAbout((long)1);
    }
}
 
