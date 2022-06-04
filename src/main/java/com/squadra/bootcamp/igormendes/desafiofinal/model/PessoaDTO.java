package com.squadra.bootcamp.igormendes.desafiofinal.model;

import lombok.Data;
@Data
public class PessoaDTO {
    private Long codigoPessoa;
    private String nome;
    private String sobrenome;
    private int idade;
    private String login;
    private String senha;
    private int status;



}
