package com.delegacia.ocorrencia.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Ocorrencia implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "text")
    private String observacoes;

    @Column(name = "data_criacao")
    private Date dataCriacao;

    @Column(name = "data_atualizacao")
    private Date dataAtualizacao;

    @Column(name = "status_ocorrencia")
    private String statusOcorrencia;

    @ManyToOne
    @JoinColumn(name = "id_agente", nullable = false)
    private Agente agente;
}
