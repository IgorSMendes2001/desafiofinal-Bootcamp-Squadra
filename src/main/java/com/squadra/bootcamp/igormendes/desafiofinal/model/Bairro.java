package com.squadra.bootcamp.igormendes.desafiofinal.model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name="tb_bairro")
public class Bairro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigoBairro;
    @Column(name = "codigo_municipio")
    private Municipio codigoMunicipio;
    private String nome;
    private int status;


}
