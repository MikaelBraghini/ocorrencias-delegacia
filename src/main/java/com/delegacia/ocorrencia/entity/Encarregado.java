package com.delegacia.ocorrencia.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "encarregado")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Encarregado implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    @ManyToMany
    @JoinTable(name = "encarregado_agente",
            joinColumns = @JoinColumn(name = "id_encarregado"),
            inverseJoinColumns = @JoinColumn(name = "id_agente", unique = true))
    private List<Agente> agente;
}
