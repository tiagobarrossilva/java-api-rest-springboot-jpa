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
import eaj.ufrn.appsandalia.domain.Sandalia;
import eaj.ufrn.appsandalia.service.SandaliaService;

@RestController
@RequestMapping("/sandalia")
public class SandaliaController {
    SandaliaService service;
    ModelMapper modelMapper = new ModelMapper();
    public SandaliaController(SandaliaService service){
        this.service = service;
    }

    //salvar um
    @PostMapping
    public ResponseEntity<Sandalia> salvar_sandalia(@RequestBody Sandalia s) throws URISyntaxException {
        Sandalia obj_sandalia = service.armazenar_sandalia(s);
        URI uri = new URI("/sandalia"+ obj_sandalia.getId());
        return ResponseEntity.created(uri).build();  
    }

    //consultar um
    @GetMapping(path = {"/{id}"})
    public ResponseEntity<?> consulta_sandalia(@PathVariable Long id ){
        if(service.findById(id).isPresent()){
            return ResponseEntity.ok().body(service.carregar_sandalia(id));
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    //consultar todos
    @GetMapping
    public List<Sandalia> listar_sandalias(){
        return service.carregar_lista_sandalias();
    }
    
    //exlcuir um
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id ){
        if(service.findById(id).isPresent()){
            service.excluir_sandalia(id);
            return ResponseEntity.ok().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    //atualizar um
    @PutMapping("/{id}")
    public ResponseEntity<Sandalia> update (@PathVariable Long id, @RequestBody Sandalia s){
        if(service.findById(id).isPresent()){
            Sandalia atualizado = service.update(s);
            return ResponseEntity.ok().body(atualizado);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}