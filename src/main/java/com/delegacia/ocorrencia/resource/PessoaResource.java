package com.delegacia.ocorrencia.resource;

import com.delegacia.ocorrencia.entity.Pessoa;
import com.delegacia.ocorrencia.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/pessoa")
public class PessoaResource {
    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Pessoa>> listarPessoas() {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.listarPessoas());
    }

    @PostMapping("/adicionar")
    public ResponseEntity<Pessoa> addPessoa(@RequestBody Pessoa pessoa) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.addPessoa(pessoa));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deletePessoa(@PathVariable long id) {
        if (pessoaService.deletePessoa(id)) {
            return ResponseEntity.status(HttpStatus.OK).body("Pessoa removida");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não contrada");
        }
    }
}
