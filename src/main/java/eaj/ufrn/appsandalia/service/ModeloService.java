package eaj.ufrn.appsandalia.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import eaj.ufrn.appsandalia.domain.Modelo;
import eaj.ufrn.appsandalia.repository.ModeloRepository;

@Service
public class ModeloService {
    ModeloRepository repository;

    public ModeloService(ModeloRepository repository){
        this.repository = repository;
    }

    public Modelo carregar_modelo(Long id){
       Optional<Modelo> optional = repository.findById(id);
        return optional.orElse(null);
    }

    public Modelo armazenar_modelo(Modelo m){
        return repository.save(m);
    }

    public Modelo atualizar_modelo(Modelo m){
        return repository.saveAndFlush(m);
    }
    
    public void excluir_modelo(Long id){
        repository.deleteById(id);
    }
}
