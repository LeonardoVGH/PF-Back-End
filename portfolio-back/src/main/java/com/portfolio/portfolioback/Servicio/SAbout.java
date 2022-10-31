/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolioback.Servicio;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.portfolio.portfolioback.Entity.About;
import com.portfolio.portfolioback.Repository.About_Repository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Leo
 */
@Service
@Transactional
public class SAbout {
    
    @Autowired
     About_Repository rAbout;
     
         
     public void save(About about){
         rAbout.save(about);
     }
     
    public Optional<About> getOne(long id)
    {
         return rAbout.findById(id);
     }
     
}
