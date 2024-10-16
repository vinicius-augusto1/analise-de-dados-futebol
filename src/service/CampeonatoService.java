package service;

import exceptions.EstatisticaNaoEncontradaException;
import model.Jogador;
import model.Partida;
import repository.JogadorRepository;
import repository.PartidaRepository;
import repository.TimeRepository;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CampeonatoService {

    private JogadorRepository jogadorRepository;
    private PartidaRepository partidaRepository;
    private TimeRepository timeRepository;


    public CampeonatoService(String jogadoresFile, String partidasFile, String timeFile) throws IOException {
        this.jogadorRepository = new JogadorRepository(jogadoresFile);
        this.partidaRepository = new PartidaRepository(partidasFile);
        this.timeRepository = new TimeRepository(timeFile);
    }

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public String timeMaisVenceu2008() {
        return partidaRepository.getPartidas().stream()
                .filter(partida -> partida.getData().contains("2008"))
                .collect(Collectors.groupingBy(Partida::getVencedor, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(entry -> String.format("O time que mais venceu em 2008 foi %s com %d vitórias.", entry.getKey(), entry.getValue()))
                .orElse("Nenhum vencedor encontrado em 2008.");
    }



    public String estadoComMenosJogos() {
        return partidaRepository.getPartidas().stream()
                .collect(Collectors.groupingBy(Partida::getMandanteEstado, Collectors.counting()))
                .entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(entry -> String.format("O estado com menos jogos entre 2003 e 2022 foi %s com apenas %d jogos.", entry.getKey(), entry.getValue()))
                .orElse("Nenhum estado encontrado.");
    }


    public Jogador jogadorComMaisGols(){
        return jogadorRepository.getJogadores().stream()
                .max(Comparator.comparingInt(Jogador::getGols))
                .orElseThrow(() -> new EstatisticaNaoEncontradaException("Jogador com mais gols"));
    }

    public Jogador jogadorComMaisGolsDePenalti(){
        return jogadorRepository.getJogadores().stream()
                .max(Comparator.comparingInt(Jogador::getGolsPenalti))
                .orElseThrow(() -> new EstatisticaNaoEncontradaException("Jogador com mais gols de penalti"));
    }

    public Jogador jogadorComMaisGolsContra(){
        return jogadorRepository.getJogadores().stream()
                .max(Comparator.comparingInt(Jogador::getGolsContra))
                .orElseThrow(() -> new EstatisticaNaoEncontradaException("O jogador com mais gols contra"));
    }

    public Jogador jogadorComMaisCartoesAmarelos(){
        return jogadorRepository.getJogadores().stream()
                .max(Comparator.comparingInt(Jogador::getCartoesAmarelos))
                .get();
    }

    public Jogador jogadorComMaisCartoesVermelhos(){
        return jogadorRepository.getJogadores().stream()
                .max(Comparator.comparingInt(Jogador::getCartoesVermelhos))
                .get();
    }

    public Partida partidaComMaisGols(){
        return partidaRepository.getPartidas().stream()
                .max(Comparator.comparing(p -> p.getMandantePlacar() + p.getVisitantePlacar()))
                .get();
    }









}
