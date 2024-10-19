package repository;

import model.Cartao;
import utils.LeitorCsv;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class CartaoRepository {
    private List<Cartao> cartoes;


    public CartaoRepository(String filePath) throws IOException {
        this.cartoes = LeitorCsv.readCsv(filePath).stream()
                .map(data -> new Cartao(
                        data[4], data[5]
                ))
                .collect(Collectors.toList());
    }
}
