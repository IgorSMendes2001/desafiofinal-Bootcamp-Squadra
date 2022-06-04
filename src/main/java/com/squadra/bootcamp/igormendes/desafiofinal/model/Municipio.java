package com.squadra.bootcamp.igormendes.desafiofinal.model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "tb_municipio")
public class Municipio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigoMunicipio;
    @Column(name = "codigo_uf")
    private Uf codigoUF;
    private String nome;
    private int status;


}   
