package com.squadra.bootcamp.igormendes.desafiofinal.model;

import lombok.Data;

@Data
public class BairroDTO {
    private Long codigoBairro;
    private Municipio codigoMunicipio;
    private String nome;
    private int status;


}
