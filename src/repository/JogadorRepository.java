package repository;

import exceptions.DadosIncompletosException;
import model.Jogador;
import utils.LeitorCsv;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class JogadorRepository {

    private List<Jogador> jogadores;

    public JogadorRepository(String filePath) throws IOException {
        this.jogadores = LeitorCsv.readCsv(filePath).stream()
                .map(data -> {
                    if (data.length < 6) {
                        throw new DadosIncompletosException("Jogador", "Dados insuficientes");
                    }

                    String nome = data[3].replace("\"", "").trim();
                    if (nome.isEmpty()) {
                        throw new DadosIncompletosException("Jogador", "Nome");
                    }

                    Jogador jogador = new Jogador(nome,
                            parseToInt(data[1], 0),
                            parseToInt(data[3], 0),
                            0,
                            parseToInt(data[4], 0),
                            parseToInt(data[5], 0)
                    );

                    return jogador;
                })
                .collect(Collectors.toList());
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    private Integer parseToInt(String value, int defaultValue) {
        if (value == null || value.isEmpty()) {
            return defaultValue;
        }

        try {
            return Integer.parseInt(value.replace("\"", "").trim());
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}
