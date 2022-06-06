package com.squadra.bootcamp.igormendes.desafiofinal.model;

import lombok.Data;

import java.util.List;

import javax.persistence.*;
@Data
@Entity
@Table(name = "tb_pessoa")
public class Pessoa {
    @Id
    @Column(name = "CODIGO_PESSOA")
    @GeneratedValue(generator = "pessoa_sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "pessoa_sequence",sequenceName = "pes_seq")
    private Long codigoPessoa;
    @OneToMany
    @JoinColumn(name = "CODIGO_ENDERECO")
    private List<Endereco> enderecos;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "SOBRENOME")
    private String sobrenome;
    @Column(name = "IDADE")
    private int idade;
    @Column(name = "LOGIN")
    private String login;
    @Column(name = "SENHA")
    private String senha;
    @Column(name = "STATUS")
    private int status;


}
