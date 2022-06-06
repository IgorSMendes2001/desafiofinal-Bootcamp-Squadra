package com.squadra.bootcamp.igormendes.desafiofinal.model;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Data
@Entity
@Table(name="tb_bairro")
public class Bairro implements Serializable{
    @Id
    @Column(name = "CODIGO_BAIRRO")
    @GeneratedValue(generator= "bairro_sequence",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="bairro_sequence",sequenceName = "bair_seq" )
    private Long codigoBairro;
    @ManyToOne
    @JoinColumn(name = "CODIGO_MUNICIPIO")
    @NotNull(message = "O código do municipio é obrigatório")
    private Municipio codigoMunicipio;
    @Column(name = "NOME")
    @NotNull(message = "O nome deve ser obrigatório")
    private String nome;
    @NotNull(message = "O status deve ser obrigatório")
    @Column(name = "STATUS")
    private int status;
    public Bairro(){

    }


}
