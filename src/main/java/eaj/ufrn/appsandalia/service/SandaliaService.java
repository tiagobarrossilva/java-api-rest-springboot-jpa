package eaj.ufrn.appsandalia.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import eaj.ufrn.appsandalia.domain.Sandalia;
import eaj.ufrn.appsandalia.repository.SandaliaRepository;

@Service
public class SandaliaService {
    SandaliaRepository repository;

    public SandaliaService(SandaliaRepository repository){
        this.repository = repository;
    }
    
    public Sandalia armazenar_sandalia(Sandalia s){
        return repository.save(s);
    }

    public Sandalia carregar_sandalia(Long id){
        Optional<Sandalia> optional = repository.findById(id);
        return optional.orElse(null);
    }

    public List<Sandalia> carregar_lista_sandalias(){
        return repository.findAll();
    }

    public void excluir_sandalia(Long id){
        repository.deleteById(id);
    }

    public Optional<Sandalia> findById(Long id){
        return repository.findById(id);
    }

    public Sandalia update(Sandalia s){
        return repository.saveAndFlush(s);
    }
}
