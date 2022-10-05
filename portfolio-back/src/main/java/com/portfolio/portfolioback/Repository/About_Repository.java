
package com.portfolio.portfolioback.Repository;

import com.portfolio.portfolioback.Entity.About;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Leo
 */

@Repository
public interface About_Repository extends JpaRepository <About,Long>{
    
    
}
