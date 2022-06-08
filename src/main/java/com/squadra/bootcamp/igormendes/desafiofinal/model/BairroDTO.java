package com.squadra.bootcamp.igormendes.desafiofinal.model;

import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class BairroDTO{
    private Long codigoBairro;
    @NotBlank(message = "Código do município não pode ser nulo!")
    private Long codigoMunicipio;
    @NotBlank(message = "Nome do bairro não pode ser nulo!")
    @Size(min=1,max = 50,message = "o nome deve ter entre 1 e 50 caracteres")
    @UniqueElements
    private String nome;
    @Min(value = 1,message = "O status deve ser 1 ou 2")
    @Max(value = 2,message = "O status deve ser 1 ou 2")
    private Integer status;


}
