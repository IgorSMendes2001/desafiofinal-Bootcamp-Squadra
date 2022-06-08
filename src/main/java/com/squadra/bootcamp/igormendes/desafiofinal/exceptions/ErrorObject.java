package com.squadra.bootcamp.igormendes.desafiofinal.exceptions;

import lombok.Data;

@Data
public class ErrorObject {
    private final String message;
    private final String field;
    private final Object parameter;
}
