package model;

public class Partida {

    private String id;
    private String rodada;
    private String data;
    private String hora;
    private String mandante;
    private String visitante;
    private String formacaoMandante;
    private String formacaoVisitante;
    private String tecnicoMandante;
    private String tecnicoVisitante;
    private String vencedor;
    private String arena;
    private String mandantePlacar;
    private String visitantePlacar;
    private String mandanteEstado;
    private String visitanteEstado;

    public Partida(String id, String rodada, String data, String hora, String mandante, String visitante, String formacaoMandante, String formacaoVisitante, String tecnicoMandante, String tecnicoVisitante, String vencedor, String arena, String mandantePlacar, String visitantePlacar, String mandanteEstado, String visitanteEstado) {
        this.id = id;
        this.rodada = rodada;
        this.data = data;
        this.hora = hora;
        this.mandante = mandante;
        this.visitante = visitante;
        this.formacaoMandante = formacaoMandante;
        this.formacaoVisitante = formacaoVisitante;
        this.tecnicoMandante = tecnicoMandante;
        this.tecnicoVisitante = tecnicoVisitante;
        this.vencedor = vencedor;
        this.arena = arena;
        this.mandantePlacar = mandantePlacar;
        this.visitantePlacar = visitantePlacar;
        this.mandanteEstado = mandanteEstado;
        this.visitanteEstado = visitanteEstado;
    }


    public String getData() {
        return data;
    }


    public String getVencedor() {
        return vencedor;
    }


    public String getArena() {
        return arena;
    }

    public void setArena(String arena) {
        this.arena = arena;
    }

    public String getMandantePlacar() {
        return mandantePlacar;
    }


    public String getVisitantePlacar() {
        return visitantePlacar;
    }


    public String getMandanteEstado() {
        return mandanteEstado;
    }


    @Override
    public String toString() {
        return "Partida ID: " + id +
                ", Rodada: " + rodada +
                ", Data: " + data +
                ", Hora: " + hora +
                ", Mandante: " + mandante +
                ", Visitante: " + visitante +
                ", Placar: " + mandantePlacar + " x " + visitantePlacar +
                ", Arena: " + arena;
    }

}
