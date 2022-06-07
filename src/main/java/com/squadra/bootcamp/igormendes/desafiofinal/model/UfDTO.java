package com.squadra.bootcamp.igormendes.desafiofinal.model;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UfDTO {
    private Long codigoUF;
    @NotBlank(message = "Sigla não pode ser nula")
    @Size(min=2,max = 2)
    private String sigla;
    @NotBlank(message = "Nome do UF não pode ser nulo")
    @Size(min=1,max = 50)
    private String nome;
    @Min(value = 1,message = "O status deve ser 1 ou 2")
    @Max(value = 2,message = "O status deve ser 1 ou 2")
    private Long status;

}
