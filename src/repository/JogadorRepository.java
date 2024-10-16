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
                    // Validação de dados
                    if (data.length < 6) {
                        throw new DadosIncompletosException("Jogador", "Dados insuficientes");
                    }

                    String nome = data[3].replace("\"", "").trim(); // Nome do jogador
                    if (nome.isEmpty()) {
                        throw new DadosIncompletosException("Jogador", "Nome");
                    }

                    // Criação do jogador
                    Jogador jogador = new Jogador(nome,
                            parseToInt(data[1], 0), // Gols
                            parseToInt(data[3], 0), // Cartões Vermelhos
                            0, // Cartões Amarelos (pode inicializar como 0 se não tiver dado)
                            parseToInt(data[4], 0), // Gols Contra
                            parseToInt(data[5], 0)   // Gols de Penalti
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
            return Integer.parseInt(value.replace("\"", "").trim()); // Lidar com aspas e espaços
        } catch (NumberFormatException e) {
            return defaultValue; // Retornar valor padrão em caso de erro
        }
    }
}
