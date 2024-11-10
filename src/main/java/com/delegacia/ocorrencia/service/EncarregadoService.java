package com.delegacia.ocorrencia.service;

import com.delegacia.ocorrencia.entity.Agente;
import com.delegacia.ocorrencia.entity.Encarregado;
import com.delegacia.ocorrencia.repositories.EncarregadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EncarregadoService {
    @Autowired
    private EncarregadoRepository encarregadoRepository;

    public Encarregado addEncarregado(Encarregado encarregado) {
        System.out.println();
        return encarregadoRepository.save(encarregado);
    }

    public List<Encarregado> listarEncarregados() {
        return encarregadoRepository.findAll();
    }

    public boolean deleteEncarregado(long id) {
        if (encarregadoRepository.findById(id).isPresent()) {
            encarregadoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Encarregado addEncarregadoAgentes(long idEncarregado, Agente agente) {
        Optional<Encarregado> encarregadoExistente = encarregadoRepository.findById(idEncarregado);

        if (encarregadoExistente.isPresent()) {
            Encarregado newEncarregado = encarregadoExistente.get();
            newEncarregado.getAgente().add(agente);
            return encarregadoRepository.save(newEncarregado);
        }
        return encarregadoRepository.save(encarregadoExistente.get());
    }

    public Encarregado updateEncarregado(Encarregado encarregado) {
        return encarregadoRepository.save(encarregado);
    }
}
