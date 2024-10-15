package service;

import model.Jogador;
import model.Partida;
import model.Time;
import repository.JogadorRepository;
import repository.PartidaRepository;
import repository.TimeRepository;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collector;
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

    public String timeMaisVenceu2008(){
        return partidaRepository.getPartidas().stream()
                .filter(p -> p.getData().substring(6).equals("2008"))
                .collect(Collectors.groupingBy(Partida::getVencedor, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue())
                .get().getKey(); // testar o "isPresent"
    }

    public String estadoComMenosJogos(){
        return partidaRepository.getPartidas().stream()
                .filter(p -> {
                    LocalDate data = LocalDate.parse(p.getData(), formatter);
                    return !data.isBefore(LocalDate.of(2003,1,1))
                            && !data.isAfter(LocalDate.of(2022,12,31));
                })
                .flatMap(p -> Stream.of(p.getMandanteEstado(), p.getVisitanteEstado()))
                .collect(Collectors.groupingBy(state -> state, Collectors.counting()))
                .entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public Jogador jogadorComMaisGols(){
        return jogadorRepository.getJogadors().stream()
                .max(Comparator.comparingInt(Jogador::getGols))
                .get();
    }

    public Jogador jogadorComMaisGolsDePenalti(){
        return jogadorRepository.getJogadors().stream()
                .max(Comparator.comparingInt(Jogador::getGolsPenalti))
                .get();
    }









}
