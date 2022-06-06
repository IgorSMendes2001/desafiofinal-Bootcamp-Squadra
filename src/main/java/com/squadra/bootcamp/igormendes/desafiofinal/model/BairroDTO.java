package com.squadra.bootcamp.igormendes.desafiofinal.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class BairroDTO implements Serializable{
    private Long codigoBairro;
    private Long codigoMunicipio;
    private String nome;
    private int status;


}
