package exceptions;

import model.Estatistica;

public class EstatisticaNaoEncontradaException extends RuntimeException{
    public EstatisticaNaoEncontradaException(String estatistica){
        super("Erro: Não foi possível calcular a estatística: " + estatistica);
    }
}
