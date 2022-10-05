
package com.portfolio.portfolioback.Entity;

import com.sun.istack.NotNull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class About {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    private String nombre;
    
    @NotNull
    private String titulo;
    
    @NotNull
    private String descripcion;
    
    private String url_img;
    private String url_banner;

   
    
}
