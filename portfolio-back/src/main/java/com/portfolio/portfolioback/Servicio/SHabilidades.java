/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolioback.Servicio;

/**
 *
 * @author Leo
 */
import com.portfolio.portfolioback.Entity.Habilidades;
import com.portfolio.portfolioback.Repository.RHabilidades;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SHabilidades {
    
     @Autowired
     RHabilidades rHabilidades;
     
     public List<Habilidades> list(){
         return rHabilidades.findAll();
     }
     
     public Optional<Habilidades> getOne(int id){
         return rHabilidades.findById(id);
     }
     
     public Optional<Habilidades> getBynombre(String nombre){
         return rHabilidades.findBynombre(nombre);
     }
     
     public void save(Habilidades habilis){
         rHabilidades.save(habilis);
     }
     
     public void delete(int id){
         rHabilidades.deleteById(id);
     }
     
     public boolean existsById(int id){
         return rHabilidades.existsById(id);
     }
     
     public boolean existsBynombre(String nombre){
         return rHabilidades.existsBynombre(nombre);
     }
    
}
