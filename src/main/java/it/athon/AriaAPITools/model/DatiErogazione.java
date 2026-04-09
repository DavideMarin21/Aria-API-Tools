package it.athon.AriaAPITools.model;

public class DatiErogazione {

    private String codicePrestazione;
    private String tipoAmbulatorio;

    public DatiErogazione() {}

    public String getCodicePrestazione() {
        return codicePrestazione;
    }

    public void setCodicePrestazione(String codicePrestazione) {
        this.codicePrestazione = codicePrestazione;
    }

    public String getTipoAmbulatorio() {
        return tipoAmbulatorio;
    }

    public void setTipoAmbulatorio(String tipoAmbulatorio) {
        this.tipoAmbulatorio = tipoAmbulatorio;
    }
    
}
