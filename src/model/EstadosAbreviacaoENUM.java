package model;

public enum EstadosAbreviacaoENUM {
    AC("Acre"),
    AL("Alagoas"),
    AP("Amapá"),
    BA("Bahia"),
    CE("Ceará"),
    DF("Distrito Federal"),
    ES("Espírito Santo"),
    GO("Goiás"),
    MA("Maranhão"),
    MT("Mato Grosso"),
    MS("Mato Grosso do Sul"),
    MG("Minas Gerais"),
    PA("Pará"),
    PB("Paraíba"),
    PR("Paraná"),
    PE("Pernambuco"),
    PI("Piauí"),
    RJ("Rio de Janeiro"),
    RN("Rio Grande do Norte"),
    RS("Rio Grande do Sul"),
    RO("Rondônia"),
    RR("Roraima"),
    SC("Santa Catarina"),
    SP("São Paulo"),
    SE("Sergipe"),
    TO("Tocantins");

    private final String nomeCompletoEstado;

    EstadosAbreviacaoENUM(String nomeCompletoEstado) {
        this.nomeCompletoEstado = nomeCompletoEstado;
    }

    public String getNomeCompletoEstado() {
        return nomeCompletoEstado;
    }

    public static String getNomePorSigla(String sigla) {
        if (sigla != null) {
            sigla = sigla.replace("\"", "").trim();
            for (EstadosAbreviacaoENUM estado : EstadosAbreviacaoENUM.values()) {
                if (estado.name().equals(sigla)) {
                    return estado.getNomeCompletoEstado();
                }
            }
        }
        return null;
    }
}
