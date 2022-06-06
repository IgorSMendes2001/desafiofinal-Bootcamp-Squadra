package com.squadra.bootcamp.igormendes.desafiofinal.model;

import java.util.List;

import lombok.Data;
@Data
public class PessoaDTO {
    private Long codigoPessoa;
    private List<EnderecoDTO> enderecos;
    private String nome;
    private String sobrenome;
    private int idade;
    private String login;
    private String senha;
    private int status;



}
