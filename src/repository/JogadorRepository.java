package repository;

import exceptions.DadosIncompletosException;
import model.Jogador;
import utils.LeitorCsv;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class JogadorRepository {

    private List<Jogador> jogadors;

    public JogadorRepository(String filePath) throws IOException{
        this.jogadors = LeitorCsv.readCsv(filePath).stream()
                .map(data -> {
                    if (data[0] == null || data[0].isEmpty()) {
                        throw new DadosIncompletosException("Jogador", "Nome");
                    }
                    return new Jogador(data[0]);
                })
                .collect(Collectors.toList());
    }

    public List<Jogador> getJogadors() {
        return jogadors;
    }
}
