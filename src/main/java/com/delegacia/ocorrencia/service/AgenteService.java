package com.delegacia.ocorrencia.service;

import com.delegacia.ocorrencia.entity.Agente;
import com.delegacia.ocorrencia.repositories.AgenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgenteService {
    @Autowired
    private AgenteRepository agenteRepository;

    public Agente addAgente(Agente agente) {
        return agenteRepository.save(agente);
    }

    public List<Agente> listarAgentes() {
        return agenteRepository.findAll();
    }

    public boolean deleteAgente(long id) {
        if (agenteRepository.findById(id).isPresent()) {
            agenteRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
}
