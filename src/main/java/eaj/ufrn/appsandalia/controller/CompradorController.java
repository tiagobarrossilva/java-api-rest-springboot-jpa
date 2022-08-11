package eaj.ufrn.appsandalia.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import eaj.ufrn.appsandalia.domain.Comprador;
import eaj.ufrn.appsandalia.service.CompradorService;

@RestController
@RequestMapping("/comprador")
public class CompradorController {
    CompradorService service;
    ModelMapper modelMapper = new ModelMapper();
    public CompradorController(CompradorService service){
        this.service = service;
    }

    //salvar um
    @PostMapping
    public ResponseEntity<Comprador> salvar_sandalia(@RequestBody Comprador s) throws URISyntaxException {
        Comprador obj_comprador = service.armazenar_comprador(s);
        URI uri = new URI("/comprador"+ obj_comprador.getId());
        return ResponseEntity.created(uri).build();  
    }

    //consultar um
    @GetMapping(path = {"/{id}"})
    public ResponseEntity<?> consulta_comprador(@PathVariable Long id ){
        if(service.findById(id).isPresent()){
            return ResponseEntity.ok().body(service.carregar_comprador(id));
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    //consultar todos
    @GetMapping
    public List<Comprador> listar_sandalias(){
        return service.carregar_lista_comprador();
    }

    //exlcuir um
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id ){
        if(service.findById(id).isPresent()){
            service.excluir_comprador(id);
            return ResponseEntity.ok().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    //atualizar um
    @PutMapping("/{id}")
    public ResponseEntity<Comprador> update (@PathVariable Long id, @RequestBody Comprador s){
        if(service.findById(id).isPresent()){
            Comprador atualizado = service.update(s);
            return ResponseEntity.ok().body(atualizado);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}