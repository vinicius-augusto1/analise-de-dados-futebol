package controller;

import service.CampeonatoService;

import java.io.IOException;

public class CampeonatoController {

    private CampeonatoService service;

    public CampeonatoController(String jogadorFile, String partidasFile, String timesFile, String cartaoFile) throws IOException{
        this.service = new CampeonatoService(jogadorFile, partidasFile, timesFile, cartaoFile);
    }


    public void exibirEstatisticas() throws IOException {
//        System.out.println("Time que mais venceu em 2008: " + service.timeMaisVenceu2008());
//        System.out.println("Estado que teve menos jogos entre 2003 e 2022: " + service.estadoComMenosJogos());
//        System.out.println("O jogador que mais fez gols: " + service.jogadorComMaisGols());
//        System.out.println("O jogador que mais fez gols de penalti: " + service.jogadorComMaisGolsDePenalti());
//        System.out.println("O jogoador que mais fez gols contra: " + service.jogadorComMaisGolsContra());
//        System.out.println("O jogador com mais cartões amarelos: " + service.jogadorComMaisCartoesAmarelos());
//        System.out.println("O jogador com mais cartões vermelhos: " + service.jogadorComMaisCartoesVermelhos());
//        System.out.println("O placar da partida com mais gols: " + service.partidaComMaisGols());

        System.out.println("Mais 2008 --> "+service.timeMaisVenceu2008() + "  FUNCIONA, MAS TEM QUE RESOLVER ESSE BUG");
        System.out.println("Menos 2003 a 2022 --> "+service.estadoComMenosJogos() + "  ESTÁ OK, MAS TEM ALGUMAS FEATURES");
        System.out.println("+ Gols --> "+service.jogadorComMaisGols());
        System.out.println("+ Penaltis --> "+service.jogadorComMaisGolsDePenalti());
        System.out.println("+ Contra --> "+service.jogadorComMaisGolsContra());
        System.out.println("+ Amarelos  --> "+service.jogadorComMaisCartoesAmarelos() + "  ESTÁ OK");
        System.out.println("+ Vermelhos --> "+ service.jogadorComMaisCartoesVermelhos() + "  ESTÁ OK");
        System.out.println("+ Gols Partida --> "+service.partidaComMaisGols() + "  ESTÁ OK");
    }

}
