package com.delegacia.ocorrencia.repositories;

import com.delegacia.ocorrencia.entity.Encarregado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncarregadoRepository extends JpaRepository<Encarregado, Long> {
}
