package it.athon.AriaAPITools.model;

import java.util.List;


public class DatiRichiesta {

    private String idRichiesta;
    private DatiCittadino datiCittadino;
    private List<Prescrizione> prescrizioni;

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
    public List<Prescrizione> getPrescrizioni() {
        return prescrizioni;
    }
    public void setPrescrizioni(List<Prescrizione> prescrizioni) {
        this.prescrizioni = prescrizioni;
    }

}
