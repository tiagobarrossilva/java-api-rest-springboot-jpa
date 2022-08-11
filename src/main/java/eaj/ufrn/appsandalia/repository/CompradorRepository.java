package eaj.ufrn.appsandalia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import eaj.ufrn.appsandalia.domain.Comprador;

public interface CompradorRepository extends JpaRepository<Comprador,Long>{
    
}