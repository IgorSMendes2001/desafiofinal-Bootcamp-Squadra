package com.squadra.bootcamp.igormendes.desafiofinal.model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "tb_uf")
public class Uf {
    @Id
    @Column(name = "CODIGO_UF")
    @GeneratedValue(generator = "uf_sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "uf_sequence",sequenceName = "uf_seq")
    private Long codigoUF;
    @Column(name = "SIGLA")
    private String sigla;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "STATUS")
    private int status;

}
