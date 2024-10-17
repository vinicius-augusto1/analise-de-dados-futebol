import controller.CampeonatoController;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            CampeonatoController campeonatoController = new CampeonatoController(
                    "src/data/campeonato-brasileiro-gols.csv",
                    "src/data/campeonato-brasileiro-full.csv",
                    "src/data/campeonato-brasileiro-estatisticas-full.csv",
                    "src/data/campeonato-brasileiro-cartoes.csv"
            );
            campeonatoController.exibirEstatisticas();
        }catch (IOException e){
            System.out.println("Error ao ler os arquivos: " + e.getMessage());
        }
    }
}