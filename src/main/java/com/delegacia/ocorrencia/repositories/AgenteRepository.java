package com.delegacia.ocorrencia.repositories;

import com.delegacia.ocorrencia.entity.Agente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenteRepository extends JpaRepository<Agente, Long> {
}
