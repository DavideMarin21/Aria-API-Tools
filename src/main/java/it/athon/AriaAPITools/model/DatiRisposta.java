package it.athon.AriaAPITools.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DatiRisposta {

    private String idRisposta;
    private DatiCittadino datiCittadino;
    @JsonProperty("prescrizioni")
    private List<Prescrizione> prescrizioni;
    private List<Warning> warning;

    public DatiRisposta() {}
    
    public String getIdRisposta() {
        return idRisposta;
    }
    public void setIdRisposta(String idRisposta) {
        this.idRisposta = idRisposta;
    }
    public DatiCittadino getDatiCittadino() {
        return datiCittadino;
    }
    public void setDatiCittadino(DatiCittadino datiCittadino) {
        this.datiCittadino = datiCittadino;
    }
    public List<Prescrizione> getPrescrizione() {
        return prescrizioni;
    }
    public void setPrescrizione(List<Prescrizione> prescrizione) {
        this.prescrizioni = prescrizione;
    }
    public List<Warning> getWarning() {
        return warning;
    }
    public void setWarning(List<Warning> warning) {
        this.warning = warning;
    }
 
}
