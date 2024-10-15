package model;

public class Jogador {

    private String nome;
    private Integer gols;
    private Integer cartoesAmarelos;
    private Integer cartoesVermelhos;
    private Integer golsContra;
    private Integer golsPenalti;

    public Jogador(String nome) {
        this.nome = nome;
    }

    public void adicionarGols(Integer quantidade){
        this.gols += quantidade;
    }

    public void adicionarCartaoAmarelo(){
        this.cartoesAmarelos++;
    }

    public void adicionarCartaoVermelho(){
        this.cartoesVermelhos++;
    }

    public void adicionarGolContra(){
        this.golsContra++;
    }

    public void adicionarGolPenalti(){
        this.golsPenalti++;
    }

    public String getNome() {
        return nome;
    }

    public Integer getGols() {
        return gols;
    }

    public Integer getCartoesAmarelos() {
        return cartoesAmarelos;
    }

    public Integer getCartoesVermelhos() {
        return cartoesVermelhos;
    }

    public Integer getGolsContra() {
        return golsContra;
    }

    public Integer getGolsPenalti() {
        return golsPenalti;
    }
}
