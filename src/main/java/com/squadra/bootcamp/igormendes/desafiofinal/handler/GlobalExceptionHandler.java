package com.squadra.bootcamp.igormendes.desafiofinal.handler;

import com.squadra.bootcamp.igormendes.desafiofinal.error.ErroDTO;
import com.squadra.bootcamp.igormendes.desafiofinal.error.RecursoNaoEncontradoException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ErroDTO handleRecurso(RecursoNaoEncontradoException rneException){
        RecursoNaoEncontradoException rneDetails=RecursoNaoEncontradoException.RecursoNaoEncontradoExceptionBuilder
                .newBuilder()
                .status(400)
                .titulo("Recurso não encontrado")
                .detail(rneException.getDevMensagem())
                .devMensagem(rneException.getClass().getName())
                .build();
        return new ErroDTO(400,rneDetails.getDevMensagem());
    }
}
