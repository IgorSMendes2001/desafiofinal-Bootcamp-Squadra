package com.squadra.bootcamp.igormendes.desafiofinal.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class MunicipioDTO implements Serializable{
    private Long codigoMunicipio;
    private Long codigoUF;
    private String nome;
    private int status;

}
