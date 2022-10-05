/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.portfolioback.Interfase;

import com.portfolio.portfolioback.Entity.About;
import java.util.List;

/**
 *
 * @author Leo
 */
public interface About_interfase_servicio {
    
    public List<About> getAbout();
    public void saveAbout (About about);
    public void deleteAbout (Long id);
    public About findAbout (Long id);
    
    
}
