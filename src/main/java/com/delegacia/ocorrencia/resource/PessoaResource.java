package com.delegacia.ocorrencia.resource;

import com.delegacia.ocorrencia.entity.Pessoa;
import com.delegacia.ocorrencia.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaResource {
    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/listar")
    public List<Pessoa> listarPessoas() {
        return pessoaService.listarPessoas();
    }

    @PostMapping("/adicionar")
    public Pessoa addPessoa(@RequestBody Pessoa pessoa) {
        return pessoaService.addPessoa(pessoa);
    }
}
