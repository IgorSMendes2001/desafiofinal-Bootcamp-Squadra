package com.squadra.bootcamp.igormendes.desafiofinal.model;

import lombok.Data;

@Data
public class EnderecoDTO {
    private Long codigoEndereco;
    private Long codigoPessoa;
    private Long codigoBairro;
    private String nomeRua;
    private String numero;
    private String complemento;
    private String cep;
}
