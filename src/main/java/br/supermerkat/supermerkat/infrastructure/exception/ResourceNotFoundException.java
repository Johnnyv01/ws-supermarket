package br.supermerkat.supermerkat.infrastructure.exception;

public class ResourceNotFoundException extends NegocioExcepion {

    public ResourceNotFoundException(String mensagem) {
        super(mensagem);
    }
}
