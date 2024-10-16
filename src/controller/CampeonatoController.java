package controller;

import model.Jogador;
import model.Partida;
import service.CampeonatoService;

import java.io.IOException;

public class CampeonatoController {

    private CampeonatoService service;

    public CampeonatoController(String jogadorFile, String partidasFile, String timesFile) throws IOException{
        this.service = new CampeonatoService(jogadorFile, partidasFile, timesFile);
    }


    public void exibirEstatisticas(){
//        System.out.println("Time que mais venceu em 2008: " + service.timeMaisVenceu2008());
//        System.out.println("Estado que teve menos jogos entre 2003 e 2022: " + service.estadoComMenosJogos());
//        System.out.println("O jogador que mais fez gols: " + service.jogadorComMaisGols());
//        System.out.println("O jogador que mais fez gols de penalti: " + service.jogadorComMaisGolsDePenalti());
//        System.out.println("O jogoador que mais fez gols contra: " + service.jogadorComMaisGolsContra());
//        System.out.println("O jogador com mais cartões amarelos: " + service.jogadorComMaisCartoesAmarelos());
//        System.out.println("O jogador com mais cartões vermelhos: " + service.jogadorComMaisCartoesVermelhos());
//        System.out.println("O placar da partida com mais gols: " + service.partidaComMaisGols());

        System.out.println(service.timeMaisVenceu2008());
        System.out.println(service.estadoComMenosJogos());
        System.out.println(service.jogadorComMaisGols());
        System.out.println(service.jogadorComMaisGolsDePenalti());
        System.out.println(service.jogadorComMaisGolsContra());
        System.out.println(service.jogadorComMaisCartoesAmarelos());
        System.out.println(service.jogadorComMaisCartoesVermelhos());
        System.out.println(service.partidaComMaisGols());
    }

}
