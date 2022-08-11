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
import eaj.ufrn.appsandalia.domain.Compra;
import eaj.ufrn.appsandalia.service.CompraService;

@RestController
@RequestMapping("/compra")
public class CompraController {
    CompraService service;
    ModelMapper modelMapper = new ModelMapper();
    public CompraController(CompraService service){
        this.service = service;
    }

    //salvar um
    @PostMapping
    public ResponseEntity<Compra> salvar_sandalia(@RequestBody Compra s) throws URISyntaxException {
        Compra obj_comprador = service.armazenar_compra(s);
        URI uri = new URI("/compra"+ obj_comprador.getId());
        return ResponseEntity.created(uri).build();  
    }

    //consultar um
    @GetMapping(path = {"/{id}"})
    public ResponseEntity<?> consulta_compra(@PathVariable Long id ){
        if(service.findById(id).isPresent()){
            return ResponseEntity.ok().body(service.carregar_compra(id));
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    //consultar todos
    @GetMapping
    public List<Compra> listar_compras(){
        return service.carregar_lista_compra();
    }

    //excluir um
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id ){
        if(service.findById(id).isPresent()){
            service.excluir_compra(id);
            return ResponseEntity.ok().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    //atualizar um
    @PutMapping("/{id}")
    public ResponseEntity<Compra> update (@PathVariable Long id, @RequestBody Compra s){
        if(service.findById(id).isPresent()){
            Compra atualizado = service.update(s);
            return ResponseEntity.ok().body(atualizado);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}