package com.squadra.bootcamp.igormendes.desafiofinal.model;

import lombok.Data;

@Data
public class EnderecoDTO {
    private Long codigoEndereco;
    private Pessoa codigoPessoa;
    private Bairro codigoBairro;
    private String nomeRua;
    private String numero;
    private String complemento;
    private String cep;
}
