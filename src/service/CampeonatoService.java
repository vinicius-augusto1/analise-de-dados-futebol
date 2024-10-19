package service;

import exceptions.EstatisticaNaoEncontradaException;
import model.EstadosAbreviacaoENUM;
import model.Jogador;
import model.Partida;
import repository.CartaoRepository;
import repository.JogadorRepository;
import repository.PartidaRepository;
import repository.TimeRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CampeonatoService {

    private JogadorRepository jogadorRepository;
    private PartidaRepository partidaRepository;
    private TimeRepository timeRepository;
    private CartaoRepository cartaoRepository;



    public CampeonatoService(String jogadoresFile, String partidasFile, String timeFile, String cartaoFile) throws IOException {
        this.jogadorRepository = new JogadorRepository(jogadoresFile);
        this.partidaRepository = new PartidaRepository(partidasFile);
        this.timeRepository = new TimeRepository(timeFile);
        this.cartaoRepository = new CartaoRepository(cartaoFile);
    }


    public String timeMaisVenceu2008() {
        return partidaRepository.getPartidas().stream()
                .filter(partida -> partida.getData().contains("2008"))
                .collect(Collectors.groupingBy(Partida::getVencedor, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(entry -> String.format("O time que mais venceu em 2008 foi %s com %d vitórias.", entry.getKey(), entry.getValue()))
                .orElse("Nenhum vencedor encontrado em 2008.");
    }







//    public String estadoComMenosJogos() {
//        return partidaRepository.getPartidas().stream()
//                .collect(Collectors.groupingBy(Partida::getMandanteEstado, Collectors.counting()))
//                .entrySet().stream()
//                .min(Map.Entry.comparingByValue())
//                .map(entry -> String.format("O estado com menos jogos entre 2003 e 2022 foi %s com apenas %d jogos.", entry.getKey(), entry.getValue()))
//                .orElse("Nenhum estado encontrado.");
//    }

    public String estadoComMenosJogos() {
        return partidaRepository.getPartidas().stream()
                .collect(Collectors.groupingBy(Partida::getMandanteEstado, Collectors.counting()))
                .entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(entry -> {
                    String nomeEstado = EstadosAbreviacaoENUM.getNomePorSigla(entry.getKey());
                    String estadoResultado = (nomeEstado != null) ? nomeEstado : entry.getKey();

                    return String.format("O estado com menos jogos entre 2003 e 2022 foi %s com apenas %d jogos.", estadoResultado, entry.getValue());
                })
                .orElse("Nenhum estado encontrado.");
    }




    public List<Jogador> carregarJogadores(String csvFile) {
        List<Jogador> jogadores = new ArrayList<>();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length < 6) {
                    System.out.println("Linha inválida: " + line);
                    continue;
                }

                String clube = data[2].replaceAll("\"", "").trim();
                String atleta = data[3].replaceAll("\"", "").trim();
                String tipoDeGol = data[5].replaceAll("\"", "").trim();




                Jogador jogador = jogadores.stream()
                        .filter(j -> j.getNome().equals(atleta) && j.getClube().equals(clube))
                        .findFirst()
                        .orElseGet(() -> {
                            Jogador novoJogador = new Jogador(atleta, 0, 0, 0, 0, 0); // Inicia com zero gols, cartões, etc.
                            novoJogador.setClube(clube);
                            jogadores.add(novoJogador);
                            return novoJogador;
                        });

                jogador.adicionarGol(tipoDeGol);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jogadores;
    }

    public String jogadorComMaisGols() {
        List<Jogador> jogadores = carregarJogadores("src/data/campeonato-brasileiro-gols.csv");

        Jogador jogador = jogadores.stream()
                .max(Comparator.comparingInt(Jogador::getGols))
                .orElseThrow(() -> new EstatisticaNaoEncontradaException("Jogador com mais gols"));

        return String.format("Nome: %s, Clube: %s, Gols: %d", jogador.getNome(), jogador.getClube(), jogador.getGols());
    }

    public String jogadorComMaisGolsDePenalti() {
        List<Jogador> jogadores = carregarJogadores("src/data/campeonato-brasileiro-gols.csv");

        Jogador jogador = jogadores.stream()
                .max(Comparator.comparingInt(Jogador::getGolsPenalti))
                .orElseThrow(() -> new EstatisticaNaoEncontradaException("Jogador com mais gols de penalti"));

        return String.format("Nome: %s, Clube: %s, Gols de Penalti: %d", jogador.getNome(), jogador.getClube(), jogador.getGolsPenalti());
    }

    public String jogadorComMaisGolsContra() {
        List<Jogador> jogadores = carregarJogadores("src/data/campeonato-brasileiro-gols.csv");

        Jogador jogador = jogadores.stream()
                .max(Comparator.comparingInt(Jogador::getGolsContra))
                .orElseThrow(() -> new EstatisticaNaoEncontradaException("O jogador com mais gols contra"));

        return String.format("Nome: %s, Clube: %s, Gols Contra: %d", jogador.getNome(), jogador.getClube(), jogador.getGolsContra());
    }









    public String jogadorComMaisCartoesAmarelos() throws IOException {

        Map<String, Long> contagemCartoesVermelhos = Files.lines(Paths.get("src/data/campeonato-brasileiro-cartoes.csv"))
                .skip(1)
                .map(linha -> linha.split(","))
                .filter(p -> p.length == 8)
                .filter(p -> p[3].equalsIgnoreCase("Amarelo"))
                .collect(Collectors.groupingBy(
                        p -> p[4],
                        Collectors.counting()
                ));

        return contagemCartoesVermelhos.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(entry -> String.format("Jogador: %s, Cartões Amarelos: %d", entry.getKey(), entry.getValue()))
                .orElse("Nenhum jogador com cartões vermelhos encontrado.");
    }



    public String jogadorComMaisCartoesVermelhos() throws IOException {

        Map<String, Long> contagemCartoesVermelhos = Files.lines(Paths.get("src/data/campeonato-brasileiro-cartoes.csv"))
                .skip(1)
                .map(linha -> linha.split(","))
                .filter(p -> p.length == 8)
                .filter(p -> p[3].equalsIgnoreCase("Vermelho"))
                .collect(Collectors.groupingBy(
                        p -> p[4],
                        Collectors.counting()
                ));

        return contagemCartoesVermelhos.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(entry -> String.format("Jogador: %s, Cartões Vermelhos: %d", entry.getKey(), entry.getValue()))
                .orElse("Nenhum jogador com cartões vermelhos encontrado.");
    }


    public Partida partidaComMaisGols() {
        return partidaRepository.getPartidas().stream()
                .max(Comparator.comparing(p -> p.getMandantePlacar() + p.getVisitantePlacar()))
                .orElseThrow(() -> new EstatisticaNaoEncontradaException("Partida com mais gols"));
    }
}
