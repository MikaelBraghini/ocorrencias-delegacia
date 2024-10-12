package com.delegacia.ocorrencia.repositories;

import com.delegacia.ocorrencia.entity.Agente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgenteRepository extends JpaRepository<Agente, Long> {
}
