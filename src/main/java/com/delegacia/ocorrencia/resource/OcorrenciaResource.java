package com.delegacia.ocorrencia.service;

import com.delegacia.ocorrencia.entity.Agente;
import com.delegacia.ocorrencia.entity.Encarregado;
import com.delegacia.ocorrencia.entity.Ocorrencia;
import com.delegacia.ocorrencia.repositories.OcorrenciaReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OcorrenciaService {
    @Autowired
    private OcorrenciaReposity ocorrenciaReposity;

    public Ocorrencia addOcorrencia(Ocorrencia ocorrencia) {
        ocorrencia.setDataCriacao(new Date(System.currentTimeMillis()));
        return ocorrenciaReposity.save(ocorrencia);
    }

    public List<Ocorrencia> findAll() {
        return ocorrenciaReposity.findAll();
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
