package it.athon.AriaAPITools.model;

/**
 * Modello di dati relativo a DatiRichiesta per la richiesta JSON
 */
import java.util.List;

public class DatiRichiesta {

    private String idRichiesta;
    private DatiCittadino datiCittadino;
    private List<DatiPrescrizione> prescrizioni;

    public DatiRichiesta() {}

    public String getIdRichiesta() {
        return idRichiesta;
    }
    public void setIdRichiesta(String idRichiesta) {
        this.idRichiesta = idRichiesta;
    }
    public DatiCittadino getDatiCittadino() {
        return datiCittadino;
    }
    public void setDatiCittadino(DatiCittadino datiCittadino) {
        this.datiCittadino = datiCittadino;
    }
    public List<DatiPrescrizione> getPrescrizioni() {
        return prescrizioni;
    }
    public void setPrescrizioni(List<DatiPrescrizione> prescrizioni) {
        this.prescrizioni = prescrizioni;
    }

}
