package service;

import model.Cartao;
import model.Estatistica;
import model.Partida;
import repository.CartaoRepository;
import repository.EstatisticaRepository;
import repository.PartidaRepository;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EstatisticasService {

    private PartidaRepository partidaRepository;
    private CartaoRepository cartaoRepository;
    private EstatisticaRepository estatisticaRepository;

    public EstatisticasService(String pathPartidas, String pathCartoes, String pathEstatisticas) throws IOException {
        this.partidaRepository = new PartidaRepository(pathPartidas);
        this.cartaoRepository = new CartaoRepository(pathCartoes);
        this.estatisticaRepository = new EstatisticaRepository(pathEstatisticas);
    }

    public String timeMaisVenceu2008() {
        return partidaRepository.getPartidas().stream()
                .filter(partida -> partida.getData().contains("2008"))
                .collect(Collectors.groupingBy(Partida::getVencedor, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Nenhum vencedor encontrado");
    }

    public String estadoComMenosJogos() {
        return partidaRepository.getPartidas().stream()
                .collect(Collectors.groupingBy(Partida::getMandanteEstado, Collectors.counting()))
                .entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Nenhum estado encontrado");
    }

    public String jogadorComMaisGols() {
        return estatisticaRepository.getEstatisticaList().stream()
                .collect(Collectors.groupingBy(Estatistica::getClube, Collectors.summingInt(Estatistica::getChutes)))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Nenhum jogador encontrado");
    }

    public String jogadorComMaisGolsDePenalti() {
        return estatisticaRepository.getEstatisticaList().stream()
                .filter(e -> e.getClube().equals("Penalti")) // Ajustar conforme o tipo de dado no CSV
                .collect(Collectors.groupingBy(Estatistica::getClube, Collectors.summingInt(Estatistica::getChutes)))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Nenhum jogador encontrado");
    }

    public String jogadorComMaisGolsContra() {
        return estatisticaRepository.getEstatisticaList().stream()
                .filter(e -> e.getClube().equals("Contra")) // Ajustar conforme o tipo de dado no CSV
                .collect(Collectors.groupingBy(Estatistica::getClube, Collectors.summingInt(Estatistica::getChutes)))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Nenhum jogador encontrado");
    }

    public String jogadorComMaisCartoesAmarelos() {
        return cartaoRepository.getCartoes().stream()
                .filter(c -> c.getCartao().equalsIgnoreCase("amarelo"))
                .collect(Collectors.groupingBy(Cartao::getAtleta, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Nenhum jogador encontrado");
    }

    public String jogadorComMaisCartoesVermelhos() {
        return cartaoRepository.getCartoes().stream()
                .filter(c -> c.getCartao().equalsIgnoreCase("vermelho"))
                .collect(Collectors.groupingBy(Cartao::getAtleta, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Nenhum jogador encontrado");
    }

    public String partidaComMaisGols() {
        return partidaRepository.getPartidas().stream()
                .max(Comparator.comparingInt(p -> Integer.parseInt(p.getMandantePlacar() + p.getVisitantePlacar())))
                .map(partida -> String.format("%s vs %s - Placar: %d x %d",
                        partida.getMandante(), partida.getVisitante(), partida.getMandantePlacar(), partida.getVisitantePlacar()))
                .orElse("Nenhuma partida encontrada");
    }
}
