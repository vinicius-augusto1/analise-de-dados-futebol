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


    public Integer getPartidaId() {
        return partidaId;
    }

    public void setPartidaId(Integer partidaId) {
        this.partidaId = partidaId;
    }

    public String getRodada() {
        return rodada;
    }

    public void setRodada(String rodada) {
        this.rodada = rodada;
    }

    public String getClube() {
        return clube;
    }

    public void setClube(String clube) {
        this.clube = clube;
    }

    public Integer getChutes() {
        return chutes;
    }

    public void setChutes(Integer chutes) {
        this.chutes = chutes;
    }

    public Integer getChutesNoAlvo() {
        return chutesNoAlvo;
    }

    public void setChutesNoAlvo(Integer chutesNoAlvo) {
        this.chutesNoAlvo = chutesNoAlvo;
    }

    public Double getPosseDeBola() {
        return posseDeBola;
    }

    public void setPosseDeBola(Double posseDeBola) {
        this.posseDeBola = posseDeBola;
    }

    public Integer getPassos() {
        return passos;
    }

    public void setPassos(Integer passos) {
        this.passos = passos;
    }

    public Double getPrecisaoPasses() {
        return precisaoPasses;
    }

    public void setPrecisaoPasses(Double precisaoPasses) {
        this.precisaoPasses = precisaoPasses;
    }

    public Integer getFaltas() {
        return faltas;
    }

    public void setFaltas(Integer faltas) {
        this.faltas = faltas;
    }

    public Integer getCartaoAmarelo() {
        return cartaoAmarelo;
    }

    public void setCartaoAmarelo(Integer cartaoAmarelo) {
        this.cartaoAmarelo = cartaoAmarelo;
    }

    public Integer getCartaoVermelho() {
        return cartaoVermelho;
    }

    public void setCartaoVermelho(Integer cartaoVermelho) {
        this.cartaoVermelho = cartaoVermelho;
    }

    public Integer getImpedimentos() {
        return impedimentos;
    }

    public void setImpedimentos(Integer impedimentos) {
        this.impedimentos = impedimentos;
    }

    public Integer getEscanteios() {
        return escanteios;
    }

    public void setEscanteios(Integer escanteios) {
        this.escanteios = escanteios;
    }
}
