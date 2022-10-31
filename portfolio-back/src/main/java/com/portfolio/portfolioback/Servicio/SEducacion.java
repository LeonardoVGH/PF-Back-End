/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolioback.Servicio;

/**
 *
 * @author Leo
 */
import com.portfolio.portfolioback.Entity.Educacion;
import com.portfolio.portfolioback.Repository.REducacion;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SEducacion {

     @Autowired
     REducacion rEducacion;
     
     public List<Educacion> list(){
         return rEducacion.findAll();
     }
     
     public Optional<Educacion> getOne(int id){
         return rEducacion.findById(id);
     }
     
     public Optional<Educacion> getBygrado(String grado){
         return rEducacion.findBygrado(grado);
     }
     
     public void save(Educacion educa){
         rEducacion.save(educa);
     }
     
     public void delete(int id){
         rEducacion.deleteById(id);
     }
     
     public boolean existsById(int id){
         return rEducacion.existsById(id);
     }
     
     public boolean existsBygrado(String grado){
         return rEducacion.existsBygrado(grado);
     }
     
}
