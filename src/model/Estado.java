package model;

public class Estado {

    private String nome;
    private Integer quantidadeJogos;

    public Estado(String nome) {
        this.nome = nome;
        this.quantidadeJogos = 0;
    }

    public void adicionarJogo(){
        this.quantidadeJogos++;
    }

    public String getNome() {
        return nome;
    }

    public Integer getQuantidadeJogos() {
        return quantidadeJogos;
    }
}
