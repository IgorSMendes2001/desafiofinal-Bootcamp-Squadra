package com.squadra.bootcamp.igormendes.desafiofinal.model;

import java.io.Serializable;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class BairroDTO{
    private Long codigoBairro;
    private Long codigoMunicipio;
    @NotBlank(message = "O nome deve ser obrigatório")
    @Size(min=1,max = 50)
    private String nome;
    @Min(value = 1,message = "O status deve ser 1 ou 2")
    @Max(value = 2,message = "O status deve ser 1 ou 2")
    private int status;


}
