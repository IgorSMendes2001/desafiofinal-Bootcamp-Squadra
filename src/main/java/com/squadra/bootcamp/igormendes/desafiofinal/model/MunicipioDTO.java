package com.squadra.bootcamp.igormendes.desafiofinal.model;

import lombok.Data;

@Data
public class MunicipioDTO {
    private Long codigoMunicipio;
    private Uf codigoUF;
    private String nome;
    private int status;

}
