package br.com.saasSoveteria.sorveteria.exception;


import br.com.saasSoveteria.sorveteria.dto.ErroResponse;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadoraDeErros {

    @ExceptionHandler(RegraDeNegocioException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErroResponse regraDeNegocioException(RegraDeNegocioException e){
        return new ErroResponse(e.getMessage());
    }
    @ExceptionHandler(RecursoNaoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErroResponse naoEncontrado(RecursoNaoEncontradoException e){
        return new ErroResponse(e.getMessage());
    }


}
