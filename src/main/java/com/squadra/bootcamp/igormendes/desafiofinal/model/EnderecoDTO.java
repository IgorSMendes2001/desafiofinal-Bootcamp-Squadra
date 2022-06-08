package com.squadra.bootcamp.igormendes.desafiofinal.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class EnderecoDTO {
    private Long codigoEndereco;
    private Long codigoPessoa;
    private Long codigoBairro;
    @NotNull(message = "Nome da rua não pode ser nulo!")
    @Size(min=1,max = 50)
    private String nomeRua;
    @NotNull(message = "Número não pode ser nulo!")
    private String numero;
    @Size(min=1,max = 50)
    private String complemento;
    @NotNull(message = "CEP não pode ser nulo!")
    @Size(min=8,max = 8)
    private String cep;
}
