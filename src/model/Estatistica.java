package model;

public class Estatistica {

    private Integer partidaId;
    private String rodada;
    private String clube;
    private Integer chutes;
    private Integer chutesNoAlvo;
    private Double posseDeBola;
    private Integer passos;
    private Double precisaoPasses;
    private Integer faltas;
    private Integer cartaoAmarelo;
    private Integer cartaoVermelho;
    private Integer impedimentos;
    private Integer escanteios;

    public Estatistica(Integer partidaId, String rodada, String clube, Integer chutes, Integer chutesNoAlvo, Double posseDeBola, Integer passos, Double precisaoPasses, Integer faltas, Integer cartaoAmarelo, Integer cartaoVermelho, Integer impedimentos, Integer escanteios) {
        this.partidaId = partidaId;
        this.rodada = rodada;
        this.clube = clube;
        this.chutes = chutes;
        this.chutesNoAlvo = chutesNoAlvo;
        this.posseDeBola = posseDeBola;
        this.passos = passos;
        this.precisaoPasses = precisaoPasses;
        this.faltas = faltas;
        this.cartaoAmarelo = cartaoAmarelo;
        this.cartaoVermelho = cartaoVermelho;
        this.impedimentos = impedimentos;
        this.escanteios = escanteios;
    }


    public Integer getPassos() {
        return passos;
    }

    public void setPassos(Integer passos) {
        this.passos = passos;
    }


    @Override
    public String toString() {
        return "Partida ID: " + partidaId +
                ", Rodada: " + rodada +
                ", Clube: " + clube +
                ", Chutes: " + chutes +
                ", Chutes no Alvo: " + chutesNoAlvo +
                ", Posse de Bola: " + posseDeBola + "%" +
                ", Faltas: " + faltas +
                ", Cartões Amarelos: " + cartaoAmarelo +
                ", Cartões Vermelhos: " + cartaoVermelho;
    }

}
