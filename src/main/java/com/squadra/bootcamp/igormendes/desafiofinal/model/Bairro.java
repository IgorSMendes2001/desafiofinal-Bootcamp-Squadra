package com.squadra.bootcamp.igormendes.desafiofinal.model;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Data
@Entity
@Table(name="tb_bairro")
public class Bairro{
    @Id
    @Column(name = "CODIGO_BAIRRO")
    @GeneratedValue(generator= "bairro_sequence",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="bairro_sequence",sequenceName = "bair_seq" )
    private Long codigoBairro;
    @ManyToOne
    @JoinColumn(name = "CODIGO_MUNICIPIO")
    private Municipio codigoMunicipio;
    @Column(name = "NOME",unique = true)
    private String nome;
    @Column(name = "STATUS")
    private int status;
    public Bairro(){

    }


}
