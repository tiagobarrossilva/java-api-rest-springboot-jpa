package eaj.ufrn.appsandalia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import eaj.ufrn.appsandalia.domain.Comprador;
import eaj.ufrn.appsandalia.repository.CompradorRepository;

@Service
public class CompradorService {
    CompradorRepository repository;

    public CompradorService(CompradorRepository repository){
        this.repository = repository;
    }

    //armazenar
    public Comprador armazenar_comprador(Comprador c){
        return repository.save(c);
    }

    //excluir
    public void excluir_comprador(Long id){
        repository.deleteById(id);
    }

    //carregar comprador
    public Comprador carregar_comprador(Long id){
        Optional<Comprador> optional = repository.findById(id);
        return optional.orElse(null);
    }

    //carregar lista
    public List<Comprador> carregar_lista_comprador(){
        return repository.findAll();
    }

    //editar
    public Comprador update(Comprador s){
        return repository.saveAndFlush(s);
    }

    //consultar um
    public Optional<Comprador> findById(Long id){
        return repository.findById(id);
    }

    
    
}
