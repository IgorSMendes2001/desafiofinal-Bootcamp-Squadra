package com.squadra.bootcamp.igormendes.desafiofinal.model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "tb_pessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigoPessoa;
    private String nome;
    private String sobrenome;
    private int idade;
    private String login;
    private String senha;
    private int status;


}
