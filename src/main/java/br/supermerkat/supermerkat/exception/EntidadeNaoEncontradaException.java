package br.supermerkat.supermerkat.exception;

import org.hibernate.annotations.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public abstract class EntidadeNaoEncontradaException extends NegocioExcepion {

    private static final long serialVersionUID = 1L;


    public EntidadeNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}
