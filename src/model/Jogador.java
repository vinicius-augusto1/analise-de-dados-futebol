package model;

public class Jogador {

    private String nome;
    private Integer gols;
    private Integer cartoesAmarelos;
    private Integer cartoesVermelhos;
    private Integer golsContra;
    private Integer golsPenalti;

//    public Jogador(String nome) {
//        this.nome = nome;
//        this.gols = 0;
//        this.cartoesAmarelos = 0;
//        this.cartoesVermelhos = 0;
//        this.golsContra = 0;
//        this.golsPenalti = 0;
//    }
    public Jogador(String nome, Integer gols, Integer cartoesAmarelos, Integer cartoesVermelhos, Integer golsContra, Integer golsPenalti) {
        this.nome = nome;
        this.gols = gols != null ? gols : 0;
        this.cartoesAmarelos = cartoesAmarelos != null ? cartoesAmarelos : 0;
        this.cartoesVermelhos = cartoesVermelhos != null ? cartoesVermelhos : 0;
        this.golsContra = golsContra != null ? golsContra : 0;
        this.golsPenalti = golsPenalti != null ? golsPenalti : 0;
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setGols(Integer gols) {
        this.gols = gols;
    }

    public void setCartoesAmarelos(Integer cartoesAmarelos) {
        this.cartoesAmarelos = cartoesAmarelos;
    }

    public void setCartoesVermelhos(Integer cartoesVermelhos) {
        this.cartoesVermelhos = cartoesVermelhos;
    }

    public void setGolsContra(Integer golsContra) {
        this.golsContra = golsContra;
    }

    public void setGolsPenalti(Integer golsPenalti) {
        this.golsPenalti = golsPenalti;
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                ", Gols: " + gols +
                ", Gols de Penalti: " + golsPenalti +
                ", Gols Contra: " + golsContra +
                ", Cartões Amarelos: " + cartoesAmarelos +
                ", Cartões Vermelhos: " + cartoesVermelhos;
    }

}
