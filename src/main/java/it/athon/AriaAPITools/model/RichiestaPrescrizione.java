// Questa funzione permette di creare il JSON di prescrizione da inviare al servizio

package it.athon.AriaAPITools.model;

import java.util.List;


public class RichiestaPrescrizione {

    private String appl;
    private String idStruttura;
    
    private DatiOperatore datiOperatori;
    private List<DatiRichiesta> datiRichiesta;

    public RichiestaPrescrizione() {}
    
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
    public DatiOperatore getDatiOperatori() {
        return datiOperatori;
    }
    public void setDatiOperatori(DatiOperatore datiOperatori) {
        this.datiOperatori = datiOperatori;
    }
    public List<DatiRichiesta> getDatiRichiesta() {
        return datiRichiesta;
    }
    public void setDatiRichiesta(List<DatiRichiesta> datiRichiesta) {
        this.datiRichiesta = datiRichiesta;
    }

 }