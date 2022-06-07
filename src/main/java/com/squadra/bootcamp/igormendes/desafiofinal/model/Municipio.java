package com.squadra.bootcamp.igormendes.desafiofinal.model;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "tb_municipio")
public class Municipio{
    @Id
    @GeneratedValue(generator = "municipio_sequence" ,strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name= "municipio_sequence" , sequenceName = "muni_seq")
    @Column(name = "CODIGO_MUNICIPIO")
    private Long codigoMunicipio;
    @ManyToOne
    @JoinColumn(name = "CODIGO_UF")
    private Uf codigoUF;
    @Column(name = "NOME",unique = true)
    private String nome;
    @Column(name = "STATUS")
    private int status;
    public Municipio(){

    }


}   
