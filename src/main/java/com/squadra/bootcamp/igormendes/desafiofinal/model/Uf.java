package com.squadra.bootcamp.igormendes.desafiofinal.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_uf")
public class Uf {
    @Id
    @GeneratedValue(generator = "uf_sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "uf_sequence",sequenceName = "uf_seq")
    @Column(name = "CODIGO_UF")
    private Long codigoUF;
    @Column(name = "SIGLA",unique = true)
    private String sigla;
    @Column(name = "NOME",unique = true)
    private String nome;
    @Column(name = "STATUS")
    private Integer status;

}
