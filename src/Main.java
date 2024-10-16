import controller.CampeonatoController;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            CampeonatoController campeonatoController = new CampeonatoController(
                    "/home/vinicius-augusto/workspace/santander-coders/Projetos-Finais/analise-de-dados-futebol/src/data/campeonato-brasileiro-gols.csv",
                    "/home/vinicius-augusto/workspace/santander-coders/Projetos-Finais/analise-de-dados-futebol/src/data/campeonato-brasileiro-full.csv",
                    "/home/vinicius-augusto/workspace/santander-coders/Projetos-Finais/analise-de-dados-futebol/src/data/campeonato-brasileiro-estatisticas-full.csv"
            );
            campeonatoController.exibirEstatisticas();
        }catch (IOException e){
            System.out.println("Error ao ler os arquivos: " + e.getMessage());
        }
    }
}