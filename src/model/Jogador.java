package model;

public class Jogador {

    private String nome;
    private String clube;
    private Integer gols;
    private Integer golsContra;
    private Integer golsPenalti;
    private Integer cartoesAmarelos;
    private Integer cartoesVermelhos;

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

    public void adicionarGol(String tipo) {
        switch (tipo) {
            case "Gol Comum":
                gols++;
                break;
            case "Gol Contra":
                golsContra++;
                break;
            case "Penalty":
                golsPenalti++;
                break;
        }
    }

    public int totalGols() {
        return gols + golsContra + golsPenalti;
    }



    public String getNome() {
        return nome;
    }

    public Integer getGols() {
        return gols;
    }

    public Integer getGolsContra() {
        return golsContra;
    }

    public Integer getGolsPenalti() {
        return golsPenalti;
    }


    @Override
    public String toString() {
        return nome + " (" + clube + ") - Total de Gols: " + totalGols() +
                " [Gols Comum: " + gols + ", Gols Contra: " + golsContra + ", Penaltis: " + golsPenalti + "]";
    }

}
