package com.delegacia.ocorrencia.resource;

import com.delegacia.ocorrencia.entity.Ocorrencia;
import com.delegacia.ocorrencia.service.OcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ocorrencia")
public class OcorrenciaResource {
    @Autowired
    private OcorrenciaService ocorrenciaService;

    @PostMapping("/adicionar")
    public Ocorrencia addOcorrencia(@RequestBody Ocorrencia ocorrencia) {
        return ocorrenciaService.addOcorrencia(ocorrencia);
    }

    @GetMapping("/listar")
    public List<Ocorrencia> listarOcorrencias() {
        return ocorrenciaService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOcorrencia(@PathVariable long id) {
        ocorrenciaService.deleteOcorrencia(id);
    }
}
