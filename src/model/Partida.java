package model;

public class Partida {

    private Integer id;
    private String rodada;
    private String data; // usar localDate depois
    private String hora; // aqui também
    private String mandante;
    private String visitante;
    private String formacaoMandante;
    private String formacaoVisitante;
    private String tecnicoMandante;
    private String tecnicoVisitante;
    private String vencedor;
    private String arena;
    private Integer mandantePlacar;
    private Integer visitantePlacar;
    private String mandanteEstado;
    private String visitanteEstado;

    public Partida(Integer id, String rodada, String data, String hora, String mandante, String visitante, String formacaoMandante, String formacaoVisitante, String tecnicoMandante, String tecnicoVisitante, String vencedor, String arena, Integer mandantePlacar, Integer visitantePlacar, String mandanteEstado, String visitanteEstado) {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRodada() {
        return rodada;
    }

    public void setRodada(String rodada) {
        this.rodada = rodada;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMandante() {
        return mandante;
    }

    public void setMandante(String mandante) {
        this.mandante = mandante;
    }

    public String getVisitante() {
        return visitante;
    }

    public void setVisitante(String visitante) {
        this.visitante = visitante;
    }

    public String getFormacaoMandante() {
        return formacaoMandante;
    }

    public void setFormacaoMandante(String formacaoMandante) {
        this.formacaoMandante = formacaoMandante;
    }

    public String getFormacaoVisitante() {
        return formacaoVisitante;
    }

    public void setFormacaoVisitante(String formacaoVisitante) {
        this.formacaoVisitante = formacaoVisitante;
    }

    public String getTecnicoMandante() {
        return tecnicoMandante;
    }

    public void setTecnicoMandante(String tecnicoMandante) {
        this.tecnicoMandante = tecnicoMandante;
    }

    public String getTecnicoVisitante() {
        return tecnicoVisitante;
    }

    public void setTecnicoVisitante(String tecnicoVisitante) {
        this.tecnicoVisitante = tecnicoVisitante;
    }

    public String getVencedor() {
        return vencedor;
    }

    public void setVencedor(String vencedor) {
        this.vencedor = vencedor;
    }

    public String getArena() {
        return arena;
    }

    public void setArena(String arena) {
        this.arena = arena;
    }

    public Integer getMandantePlacar() {
        return mandantePlacar;
    }

    public void setMandantePlacar(Integer mandantePlacar) {
        this.mandantePlacar = mandantePlacar;
    }

    public Integer getVisitantePlacar() {
        return visitantePlacar;
    }

    public void setVisitantePlacar(Integer visitantePlacar) {
        this.visitantePlacar = visitantePlacar;
    }

    public String getMandanteEstado() {
        return mandanteEstado;
    }

    public void setMandanteEstado(String mandanteEstado) {
        this.mandanteEstado = mandanteEstado;
    }

    public String getVisitanteEstado() {
        return visitanteEstado;
    }

    public void setVisitanteEstado(String visitanteEstado) {
        this.visitanteEstado = visitanteEstado;
    }
}
