package exceptions;

public class DadosIncompletosException extends RuntimeException {
    public DadosIncompletosException(String entidade, String campoQueFalta) {
        super("Erro: Dados incompletos na entidade " + entidade + ". Campo que falta: " + campoQueFalta);
    }
}
