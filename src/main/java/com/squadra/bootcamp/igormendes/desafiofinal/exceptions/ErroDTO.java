package com.squadra.bootcamp.igormendes.desafiofinal.exceptions;

import lombok.Data;
import org.springframework.http.ResponseEntity;
@Data
public class ErroDTO  {
    public ErroDTO() {
        int status;
        String mensagem;
    }

    public ErroDTO(int status, String mensagem) {
    }

}