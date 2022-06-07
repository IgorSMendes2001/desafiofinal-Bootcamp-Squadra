package com.squadra.bootcamp.igormendes.desafiofinal.error;

import org.springframework.http.ResponseEntity;

public class ErroDTO  {
    public ErroDTO() {
        int status;
        String devMensagem;
    }

    public ErroDTO(int status, String devMensagem) {
    }

}
