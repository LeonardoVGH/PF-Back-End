
package com.portfolio.portfolioback.controller;

import com.portfolio.portfolioback.Entity.About;
import com.portfolio.portfolioback.Interfase.About_interfase_servicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@CrossOrigin (origins = "http://localhost:4200")
public class AboutController {
    @Autowired About_interfase_servicio about_interfase_servicio;
    
    @GetMapping("/about/traer")    
    public List<About> getAbout() {
    return about_interfase_servicio.getAbout();
    }
    
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
    
    @PutMapping("/about/modificar/{id}")
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
    
    }
    
    @GetMapping("/about/traer/perfil")
    public About findAbout() {
    return about_interfase_servicio.findAbout((long)2);
    }
}
 
