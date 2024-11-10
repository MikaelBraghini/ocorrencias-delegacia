package com.delegacia.ocorrencia.resource;

import com.delegacia.ocorrencia.entity.Agente;
import com.delegacia.ocorrencia.entity.Encarregado;
import com.delegacia.ocorrencia.entity.Ocorrencia;
import com.delegacia.ocorrencia.service.EncarregadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/encarregado")
public class EncarregadoResource {
    @Autowired
    private EncarregadoService encarregadoService;

    @PostMapping("/adicionar")
    public ResponseEntity<Encarregado> addEncarregado(@RequestBody Encarregado encarregado) {
        return ResponseEntity.status(HttpStatus.CREATED).body(encarregadoService.addEncarregado(encarregado));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Encarregado>> listarEncarregados() {
        return ResponseEntity.status(HttpStatus.OK).body(encarregadoService.listarEncarregados());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteAgente(@PathVariable long id) {
        if (encarregadoService.deleteEncarregado(id)) {
            return ResponseEntity.status(HttpStatus.OK).body("Encarregado removido");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Encarregado não encontrado");
        }
    }

    @PutMapping("/addAgenteEncarregado/{idEncarregado}")
    public ResponseEntity<Encarregado> updateEncarregado(@PathVariable long idEncarregado, @RequestBody Agente agente) {
        return ResponseEntity.status(HttpStatus.OK).body(encarregadoService.addEncarregadoAgentes(idEncarregado, agente));
    }
}
