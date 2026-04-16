package it.athon.AriaAPITools.model;

public class DatiErroreEstratti {

    private String codiceErrore;
    private String descErrore;

    // Costruttore
    public DatiErroreEstratti(String codiceErrore, String descErrore) {
        this.codiceErrore = codiceErrore;
        this.descErrore = descErrore;
    }

    // Getter
    public String getCodiceErrore() {
        return codiceErrore;
    }

    public String getDescErrore() {
        return descErrore;
    }
}