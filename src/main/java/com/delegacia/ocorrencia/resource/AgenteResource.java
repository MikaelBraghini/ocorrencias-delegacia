package com.delegacia.ocorrencia.resource;

import com.delegacia.ocorrencia.entity.Agente;
import com.delegacia.ocorrencia.service.AgenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agente")
public class AgenteResource {
    @Autowired
    private AgenteService agenteService;

    @PostMapping("/adicionar")
    public ResponseEntity<Agente> adicionar(@RequestBody Agente agente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(agenteService.addAgente(agente));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Agente>> listarAgentes() {
        return ResponseEntity.status(HttpStatus.OK).body(agenteService.listarAgentes());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteAgente(@PathVariable long id) {
        if (agenteService.deleteAgente(id)) {
            return ResponseEntity.status(HttpStatus.OK).body("Agente removido");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Agente não encontrado");
        }
    }
}
