package br.com.saasSoveteria.sorveteria.exception;


import br.com.saasSoveteria.sorveteria.dto.ErroResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadoraDeErrosException {

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
    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus (HttpStatus.BAD_REQUEST)
    public ErroResponse conflitoDeDados(DataIntegrityViolationException e){
        return new ErroResponse("Não foi possível salvar: os dados conflitam com um registro existente.");
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErroResponse validacaoErros(MethodArgumentNotValidException e){
        return new ErroResponse(e.getBindingResult().getFieldErrors().get(0).getDefaultMessage());


    }



}
