package it.athon.AriaAPITools.model;

import java.util.List;

public class Richiesta {
    
    String appl;
    String idStruttura;
    DatiOperatore datiOperatore;
    List<DatiRichiesta> datiRichiesta;

    public Richiesta() {}

    public String getAppl() {
        return appl;
    }
    public void setAppl(String appl) {
        this.appl = appl;
    }
    public String getIdStruttura() {
        return idStruttura;
    }
    public void setIdStruttura(String idStruttura) {
        this.idStruttura = idStruttura;
    }
    public DatiOperatore getDatiOperatore() {
        return datiOperatore;
    }
    public void setDatiOperatore(DatiOperatore datiOperatore) {
        this.datiOperatore = datiOperatore;
    }
    public List<DatiRichiesta> getDatiRichiesta() {
        return datiRichiesta;
    }
    public void setDatiRichiesta(List<DatiRichiesta> datiRichiesta) {
        this.datiRichiesta = datiRichiesta;
    }
}
