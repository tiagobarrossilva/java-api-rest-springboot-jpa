package eaj.ufrn.appsandalia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import eaj.ufrn.appsandalia.domain.Compra;
import eaj.ufrn.appsandalia.repository.CompraRepository;

@Service
public class CompraService {
    CompraRepository repository;

    public CompraService(CompraRepository repository){
        this.repository = repository;
    }
    
    //armazenar
    public Compra armazenar_compra(Compra c){
        return repository.save(c);
    }

    //excluir
    public void excluir_compra(Long id){
        repository.deleteById(id);
    }

    //carregar compra
    public Compra carregar_compra(Long id){
        Optional<Compra> optional = repository.findById(id);
        return optional.orElse(null);
    }

    //carregar lista
    public List<Compra> carregar_lista_compra(){
        return repository.findAll();
    }

     //editar
     public Compra update(Compra s){
        return repository.saveAndFlush(s);
    }

    //consultar um
    public Optional<Compra> findById(Long id){
        return repository.findById(id);
    }
}
