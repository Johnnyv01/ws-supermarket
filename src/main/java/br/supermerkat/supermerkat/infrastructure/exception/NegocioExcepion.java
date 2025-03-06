package br.supermerkat.supermerkat.infrastructure.exception;

public class NegocioExcepion  extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public NegocioExcepion(String mensagem) {
        super(mensagem);
    }

    public NegocioExcepion(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
