package com.squadra.bootcamp.igormendes.desafiofinal.model;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class PessoaDTO implements Serializable {
    private Long codigoPessoa;
    @NotBlank(message = "Endereço não pode ser nulo")
    private List<EnderecoDTO> enderecos;
    @NotBlank(message = "Nome não pode ser nulo")
    @Size(min=1,max = 50)
    private String nome;
    @NotBlank(message = "Sobrenome não pode ser nulo")
    @Size(min=1,max = 50)
    private String sobrenome;
    @NotBlank(message = "Idade não pode ser nulo")
    private int idade;
    @NotBlank(message = "Login não pode ser nulo")
    @Size(min=1,max = 50)
    private String login;
    @NotBlank(message = "Senha não pode ser nula")
    private String senha;
    @Min(value = 1,message = "O status deve ser 1 ou 2")
    @Max(value = 2,message = "O status deve ser 1 ou 2")
    private int status;



}
