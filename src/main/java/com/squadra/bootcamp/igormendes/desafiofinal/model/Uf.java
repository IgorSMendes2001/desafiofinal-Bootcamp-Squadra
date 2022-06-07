package com.squadra.bootcamp.igormendes.desafiofinal.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "tb_uf")
public class Uf {
    @Id
    @Column(name = "CODIGO_UF")
    @GeneratedValue(generator = "uf_sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "uf_sequence",sequenceName = "uf_seq")
    private Long codigoUF;
    @Column(name = "SIGLA",unique = true)
    private String sigla;
    @Column(name = "NOME",unique = true)
    private String nome;
    @Column(name = "STATUS")
    private Long status;

}
