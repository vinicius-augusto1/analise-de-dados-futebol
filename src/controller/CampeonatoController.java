package controller;

import service.CampeonatoService;
import utils.MenuEstilizado;

import java.io.IOException;

import static utils.MenuEstilizado.*;


public class CampeonatoController {

    private CampeonatoService service;


    public CampeonatoController(String jogadorFile, String partidasFile, String timesFile, String cartaoFile) throws IOException {
        this.service = new CampeonatoService(jogadorFile, partidasFile, timesFile, cartaoFile);
    }


    public void exibirEstatisticas() throws IOException {
        MenuEstilizado.printStylizedMessage(service.timeMaisVenceu2008(), ANSI_GREEN);
        MenuEstilizado.printStylizedMessage(service.estadoComMenosJogos(), ANSI_YELLOW);
        MenuEstilizado.printStylizedMessage("Mais gols: " + service.jogadorComMaisGols(), ANSI_BLUE);
        MenuEstilizado.printStylizedMessage("Mais gols de pênalti: " + service.jogadorComMaisGolsDePenalti(), ANSI_RED);
        MenuEstilizado.printStylizedMessage("Mais gols contra: " + service.jogadorComMaisGolsContra(), ANSI_YELLOW);
        MenuEstilizado.printStylizedMessage("Mais cartões amarelos: " + service.jogadorComMaisCartoesAmarelos(), ANSI_GREEN);
        MenuEstilizado.printStylizedMessage("Mais cartões vermelhos: " + service.jogadorComMaisCartoesVermelhos(), ANSI_RED);
        MenuEstilizado.printStylizedMessage("O placar da partida com mais gols: " + service.partidaComMaisGols(), ANSI_BLUE);
    }
}
