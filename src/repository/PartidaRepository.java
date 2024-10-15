package repository;

import model.Partida;
import utils.LeitorCsv;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class PartidaRepository {

    private List<Partida> partidas;

    public PartidaRepository(String filePath) throws IOException{
        this.partidas = LeitorCsv.readCsv(filePath).stream()
                .map(data -> new Partida(
                        Integer.parseInt(data[0]),
                        data[1],
                        data[2],
                        data[3],
                        data[4],
                        data[5],
                        data[6],
                        data[7],
                        data[8],
                        data[9],
                        data[10],
                        data[11],
                        Integer.parseInt(data[12]),
                        Integer.parseInt(data[13]),
                        data[14],
                        data[15]
                ))
                .collect(Collectors.toList());
    }

    public List<Partida> getPartidas(){
        return partidas;
    }

}
