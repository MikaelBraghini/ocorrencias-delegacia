package com.delegacia.ocorrencia.service;

import com.delegacia.ocorrencia.entity.Pessoa;
import com.delegacia.ocorrencia.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

    public Pessoa addPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public boolean deletePessoa(long id) {
        if (pessoaRepository.findById(id).isPresent()) {
            pessoaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
