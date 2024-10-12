package com.delegacia.ocorrencia.repositories;

import com.delegacia.ocorrencia.entity.Ocorrencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OcorrenciaReposity extends JpaRepository<Ocorrencia, Long> {

}
