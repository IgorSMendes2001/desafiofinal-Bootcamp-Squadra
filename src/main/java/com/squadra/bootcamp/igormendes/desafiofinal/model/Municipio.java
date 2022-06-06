package com.squadra.bootcamp.igormendes.desafiofinal.model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "tb_municipio")
public class Municipio {
    @Id
    @Column(name = "CODIGO_MUNICIPIO")
    @GeneratedValue(generator = "municipio_sequence" ,strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name= "municipio_sequence" , sequenceName = "muni_seq")
    private Long codigoMunicipio;
    @ManyToOne
    @JoinColumn(name = "CODIGO_UF")
    private Uf codigoUF;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "STATUS")
    private int status;


}   
