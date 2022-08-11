package eaj.ufrn.appsandalia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import eaj.ufrn.appsandalia.domain.Modelo;

public interface ModeloRepository extends JpaRepository<Modelo,Long>{
    
}