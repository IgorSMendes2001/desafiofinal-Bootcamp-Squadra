package com.squadra.bootcamp.igormendes.desafiofinal.error;

public class RecursoNaoEncontradoException extends Throwable{
    private String titulo;
    private int status;
    private String detail;
    private Long timestamp;
    private String devMensagem;
    private RecursoNaoEncontradoException(){
    }

    public String getTitulo() {
        return titulo;
    }
    public String getDevMensagem() {
        return devMensagem;
    }
    public int getStatus() {
        return status;
    }
    public String getDetail() {
        return detail;
    }
    public Long getTimestamp() {
        return timestamp;
    }

    public static final class RecursoNaoEncontradoExceptionBuilder {
        private String titulo;
        private int status;
        private String detail;
        private Long timestamp;
        private String devMensagem;

        private RecursoNaoEncontradoExceptionBuilder() {
        }

        public static RecursoNaoEncontradoExceptionBuilder newBuilder() {
            return new RecursoNaoEncontradoExceptionBuilder();
        }

        public RecursoNaoEncontradoExceptionBuilder titulo(String titulo) {
            this.titulo = titulo;
            return this;
        }

        public RecursoNaoEncontradoExceptionBuilder status(int status) {
            this.status = status;
            return this;
        }

        public RecursoNaoEncontradoExceptionBuilder detail(String detail) {
            this.detail = detail;
            return this;
        }

        public RecursoNaoEncontradoExceptionBuilder timestamp(Long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public RecursoNaoEncontradoExceptionBuilder devMensagem(String devMensagem) {
            this.devMensagem = devMensagem;
            return this;
        }

        public RecursoNaoEncontradoException build() {
            RecursoNaoEncontradoException recursoNaoEncontradoException = new RecursoNaoEncontradoException();
            recursoNaoEncontradoException.status = this.status;
            recursoNaoEncontradoException.titulo = this.titulo;
            recursoNaoEncontradoException.detail = this.detail;
            recursoNaoEncontradoException.timestamp = this.timestamp;
            recursoNaoEncontradoException.devMensagem = this.devMensagem;
            return recursoNaoEncontradoException;
        }
    }
}
