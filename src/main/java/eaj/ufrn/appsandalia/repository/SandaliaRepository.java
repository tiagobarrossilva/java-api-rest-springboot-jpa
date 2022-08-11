package eaj.ufrn.appsandalia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import eaj.ufrn.appsandalia.domain.Sandalia;

public interface SandaliaRepository extends JpaRepository<Sandalia,Long>{
    
}