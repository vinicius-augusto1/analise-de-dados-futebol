package repository;

import model.Estatistica;
import utils.LeitorCsv;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class EstatisticaRepository {
    private List<Estatistica> estatisticaList;


    public EstatisticaRepository(String filePath) throws IOException {
        this.estatisticaList = LeitorCsv.readCsv(filePath).stream()
                .map(data -> new Estatistica(
                        Integer.parseInt(data[0]),
                        data[1],
                        data[2],
                        Integer.parseInt(data[3]),
                        Integer.parseInt(data[4]),
                        Double.parseDouble(data[5]),
                        Integer.parseInt(data[6]),
                        Double.parseDouble(data[7]),
                        Integer.parseInt(data[8]),
                        Integer.parseInt(data[9]),
                        Integer.parseInt(data[10]),
                        Integer.parseInt(data[11]),
                        Integer.parseInt(data[12])
                ))
                .collect(Collectors.toList());
    }

    public List<Estatistica> getEstatisticaList(){
        return estatisticaList;
    }
}
