package com.squadra.bootcamp.igormendes.desafiofinal.model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "tb_uf")
public class Uf {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigoUF;
    private String sigla;
    private String nome;
    private int status;

}
