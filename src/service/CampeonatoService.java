package service;

import model.Partida;
import model.Time;
import repository.JogadorRepository;
import repository.PartidaRepository;
import repository.TimeRepository;

import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

public class CampeonatoService {

    private JogadorRepository jogadorRepository;
    private PartidaRepository partidaRepository;
    private TimeRepository timeRepository;


    public CampeonatoService(String jogadoresFile, String partidasFile, String timeFile) throws IOException {
        this.jogadorRepository = new JogadorRepository(jogadoresFile);
        this.partidaRepository = new PartidaRepository(partidasFile);
        this.timeRepository = new TimeRepository(timeFile);
    }

    public String timeMaisVenceu2008(){
        return partidaRepository.getPartidas().stream()
                .filter(p -> p.getData().substring(6).equals("2008"))
                .collect(Collectors.groupingBy(Partida::getVencedor, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue())
                .get().getKey(); // testar o "isPresent"
    }






}
