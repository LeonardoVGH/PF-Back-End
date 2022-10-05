
package com.portfolio.portfolioback.Servicio;

import com.portfolio.portfolioback.Entity.About;
import com.portfolio.portfolioback.Interfase.About_interfase_servicio;
import com.portfolio.portfolioback.Repository.About_Repository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Leo
 */
@Service

public class Implementacion_About_service implements About_interfase_servicio{

    @Autowired About_Repository About_Repository;
    
    @Override
    public List<About> getAbout() {
        List<About> about = About_Repository.findAll();
        return about;
    }

    @Override
    public void saveAbout(About about) {
        About_Repository.save(about);
    }

    @Override
    public void deleteAbout(Long id) {
        About_Repository.deleteById(id);
    }

    @Override
    public About findAbout(Long id) {
        About about = About_Repository.findById(id).orElse(null);
        return about;
    }
    
}
