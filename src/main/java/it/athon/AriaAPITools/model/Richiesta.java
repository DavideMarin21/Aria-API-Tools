package it.athon.AriaAPITools.model;

public class Richiesta {
    
    String appl;
    String idStruttura;
    DatiOperatore datiOperatore;
    DatiRichiesta datiRichiesta;

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
    public DatiRichiesta getDatiRichiesta() {
        return datiRichiesta;
    }
    public void setDatiRichiesta(DatiRichiesta datiRichiesta) {
        this.datiRichiesta = datiRichiesta;
    }
}
