package br.com.saasSoveteria.sorveteria.exception;

public class RecursoNaoEncontradoException extends  RuntimeException{
    public RecursoNaoEncontradoException(String mensagem){
        super(mensagem);
    }
}
