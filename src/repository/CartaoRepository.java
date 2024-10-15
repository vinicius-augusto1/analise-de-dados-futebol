package repository;

import model.Cartao;
import utils.LeitorCsv;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class CartaoRepository {
    private List<Cartao> cartoes;


    public CartaoRepository(String filePath) throws IOException{
        this.cartoes = LeitorCsv.readCsv(filePath).stream()
                .map(data -> new Cartao(
                        Integer.parseInt(data[0]),
                        data[1],
                        data[2],
                        data[3],
                        data[4],
                        Integer.parseInt(data[5]),
                        data[6],
                        data[7]
                ))
                .collect(Collectors.toList());
    }

    public List<Cartao> getCartoes(){
        return cartoes;
    }
}
