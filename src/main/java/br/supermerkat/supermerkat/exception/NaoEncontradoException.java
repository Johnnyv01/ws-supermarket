package br.supermerkat.supermerkat.exception;

public class NaoEncontradoException extends EntidadeNaoEncontradaException {

    private static final long serialVersionUID = 1L;

    public NaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public NaoEncontradoException (Long projetosId){
        this(String.format("Não existe uma busca referente ao codigo %d informado." +
                "Informe um codigo válido e tente novamente.", projetosId));
    }
}
