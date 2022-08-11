package eaj.ufrn.appsandalia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import eaj.ufrn.appsandalia.domain.Compra;

public interface CompraRepository extends JpaRepository<Compra,Long>{
    
}