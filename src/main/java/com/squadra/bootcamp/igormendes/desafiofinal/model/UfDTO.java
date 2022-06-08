package com.squadra.bootcamp.igormendes.desafiofinal.model;

import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UfDTO {
    private Long codigoUF;
    @NotBlank(message = "Sigla não pode ser nulo!")
    @Size(min=2,max = 2,message = "Valor mínimo e máximo 2!")
    @UniqueElements
    private String sigla;
    @NotBlank(message = "Nome não pode ser nulo!")
    @Size(min=1,max = 50,message = "Valor mínimo:1,Valor máximo:50")
    @UniqueElements
    private String nome;
   @Min(value = 1,message = "O status deve ser 1 ou 2")
   @Max(value = 2,message = "O status deve ser 1 ou 2")
    private Integer status;

}
