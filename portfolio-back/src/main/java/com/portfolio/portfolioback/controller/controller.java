
package com.portfolio.portfolioback.controller;

import com.portfolio.portfolioback.DTO.PropiedadDTO;
import com.portfolio.portfolioback.model.Cliente;
import com.portfolio.portfolioback.model.Inquilino;
import com.portfolio.portfolioback.model.Propiedad;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


   



@RestController
public class controller {
    
  
        
        
    @GetMapping ("/propiedad/{id}")
       @ResponseBody
    public PropiedadDTO devolverpropiedad(@PathVariable Long id) {
     
       Inquilino inqui = new Inquilino (1L, "1234566", "Walter", "White", "profesor");
       Propiedad prop = new Propiedad(16L, "casa", "308 arroyo",200.0,40000.0);
       
    PropiedadDTO propiDTO = new PropiedadDTO();
    
propiDTO.setId_propiedad(3L);
propiDTO.setNombre_inquilino("h");
propiDTO.setTipo("e");
propiDTO.setDireccion("d");
propiDTO.setValor_alquiler(500.23);
propiDTO.setApellido_inquilino("dddd");
    
    return propiDTO;
  
    }
    

    
    @PostMapping ("/cliente")
    public void nuevoCliente(@RequestBody Cliente cli) {
        
        System.out.println("nombre:"+cli.getNombre() + "Apellido:"+cli.getApellido());
        
    }
    
}
