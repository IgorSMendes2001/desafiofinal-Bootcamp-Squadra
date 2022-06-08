package com.squadra.bootcamp.igormendes.desafiofinal.model;

import lombok.Data;



import javax.persistence.*;
@Data
@Entity
@Table(name="tb_bairro")
public class Bairro{
    @Id
    @GeneratedValue(generator= "bairro_sequence",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="bairro_sequence",sequenceName = "bair_seq" )
    @Column(name = "CODIGO_BAIRRO")
    private Long codigoBairro;
    @ManyToOne
    @JoinColumn(name = "CODIGO_MUNICIPIO")
    private Municipio codigoMunicipio;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "STATUS")
    private Integer status;
    public Bairro(){

    }


}
