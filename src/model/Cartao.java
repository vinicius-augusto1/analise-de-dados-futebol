package model;

public class Cartao {
    private String cartao;
    private String atleta;

    public Cartao(String atleta, String cartao) {
        this.atleta = atleta;
        this.cartao = cartao;
    }

    public String getCartao() {
        return cartao;
    }

    public void setCartao(String cartao) {
        this.cartao = cartao;
    }

    public String getAtleta() {
        return atleta;
    }

    public void setAtleta(String atleta) {
        this.atleta = atleta;
    }

}
