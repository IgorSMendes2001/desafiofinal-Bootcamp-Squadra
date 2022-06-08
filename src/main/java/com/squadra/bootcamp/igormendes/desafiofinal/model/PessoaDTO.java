package com.squadra.bootcamp.igormendes.desafiofinal.model;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class PessoaDTO implements Serializable {
    private Long codigoPessoa;
    private List<EnderecoDTO> enderecos;
    @NotBlank(message = "Nome não pode ser nulo!")
    @Size(min=1,max = 50,message = "Seu nome deve ter entre 1 e 50 caracteres")
    @UniqueElements
    private String nome;
    @NotBlank(message = "Sobrenome não pode ser nulo!")
    @Size(min=1,max = 50,message = "Seu sobrenome deve ter entre 1 e 150 caracteres")
    private String sobrenome;
   @Min(value = 1,message = "A idade mínima é 1 ano")
   @Max(value = 120,message = "A idade máxima é 120 anos")
    private int idade;
    @NotBlank(message = "Idade não pode ser nula!")
    @Size(min=1,max = 50,message = "Seu login deve ter entre 1 e 50 caracteres")
    @UniqueElements
    private String login;
    @NotBlank(message = "Senha não pode ser nula!")
    private String senha;
    @Min(value = 1,message = "O status deve ser 1 ou 2")
    @Max(value = 2,message = "O status deve ser 1 ou 2")
    private Integer status;



}
