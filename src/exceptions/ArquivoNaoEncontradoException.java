package exceptions;

public class ArquivoNaoEncontradoException extends RuntimeException {
    public ArquivoNaoEncontradoException(String errorMessage) {
        super("Erro: Arquivo não encontrado. " + errorMessage);
    }
}
