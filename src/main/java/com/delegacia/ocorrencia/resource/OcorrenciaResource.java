package com.delegacia.ocorrencia.resource;

import com.delegacia.ocorrencia.entity.Ocorrencia;
import com.delegacia.ocorrencia.service.OcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ocorrencia")
public class OcorrenciaResource {
    @Autowired
    private OcorrenciaService ocorrenciaService;

    @PostMapping("/adicionar")
    public ResponseEntity<Ocorrencia> addOcorrencia(@RequestBody Ocorrencia ocorrencia) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ocorrenciaService.addOcorrencia(ocorrencia));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Ocorrencia>> listarOcorrencias() {
        return ResponseEntity.status(HttpStatus.OK).body(ocorrenciaService.findAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteOcorrencia(@PathVariable long id) {
        if (ocorrenciaService.deleteOcorrencia(id)) {
            return ResponseEntity.status(HttpStatus.OK).body("Ocorrencia removida");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ocorrencia não encontrada");
        }
    }
}
