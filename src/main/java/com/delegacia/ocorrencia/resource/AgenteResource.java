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
    public Agente adicionar(@RequestBody Agente agente) {
        return agenteService.addAgente(agente);
    }

    @GetMapping("/listar")
    public List<Agente> listarAgentes() {
        return agenteService.listarAgentes();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAgente(@PathVariable long id) {
        return new ResponseEntity(agenteService.deleteAgente(id), HttpStatus.OK);
    }
}
