package model;

public class Jogador {

    private String nome;
    private String clube;
    private Integer gols;
    private Integer golsContra;
    private Integer golsPenalti;
    private Integer cartoesAmarelos;
    private Integer cartoesVermelhos;


    public Jogador(String nome, Integer gols, Integer cartoesAmarelos, Integer cartoesVermelhos, Integer golsContra, Integer golsPenalti) {
        this.nome = nome;
        this.gols = gols != null ? gols : 0;
        this.cartoesAmarelos = cartoesAmarelos != null ? cartoesAmarelos : 0;
        this.cartoesVermelhos = cartoesVermelhos != null ? cartoesVermelhos : 0;
        this.golsContra = golsContra != null ? golsContra : 0;
        this.golsPenalti = golsPenalti != null ? golsPenalti : 0;
    }

    public String getNome() {
        return nome;
    }


    public String getClube() {
        return clube;
    }

    public void setClube(String clube) {
        this.clube = clube;
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
            case "":
                gols++;
                break;
        }
    }


    public int totalGols() {
        return gols + golsContra + golsPenalti;
    }


    @Override
    public String toString() {
        return nome + " (" + clube + ") - Total de Gols: " + totalGols() +
                " [Gols Comum: " + gols + ", Gols Contra: " + golsContra + ", Penaltis: " + golsPenalti + "]";
    }

}
