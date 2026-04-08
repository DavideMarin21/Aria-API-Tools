package it.athon.AriaAPITools.model;

import java.util.List;

public class DatiRisposta {

    private String idRisposta;
    private DatiCittadino datiCittadino;
    private List<Prescrizione> prescrizione;
    private List<ListaWarning> warning;
    
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
    public List<ListaWarning> getWarning() {
        return warning;
    }
    public void setWarning(List<ListaWarning> warning) {
        this.warning = warning;
    }

    
}
