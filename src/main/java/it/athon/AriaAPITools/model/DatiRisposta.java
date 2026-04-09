package it.athon.AriaAPITools.model;

import java.util.List;

public class DatiRisposta {

    private String idRisposta;
    private DatiCittadino datiCittadino;
    private List<Prescrizione> prescrizione;
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
        return prescrizione;
    }
    public void setPrescrizione(List<Prescrizione> prescrizione) {
        this.prescrizione = prescrizione;
    }
    public List<Warning> getWarning() {
        return warning;
    }
    public void setWarning(List<Warning> warning) {
        this.warning = warning;
    }
 
}
