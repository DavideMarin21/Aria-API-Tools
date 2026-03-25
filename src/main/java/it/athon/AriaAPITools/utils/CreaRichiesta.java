package it.athon.AriaAPITools.utils;

import it.athon.AriaAPITools.model.Richiesta;
import it.athon.AriaAPITools.model.DatiOperatore;
import it.athon.AriaAPITools.model.DatiRichiesta;

public class CreaRichiesta {
    
    public Richiesta creaRichiesta(String appl, String idStruttura, DatiOperatore datiOperatore, DatiRichiesta datiRichiesta) {

        Richiesta richiesta = new Richiesta();

        richiesta.setAppl(appl);
        richiesta.setIdStruttura(idStruttura);
        richiesta.setDatiOperatore(datiOperatore);
        richiesta.setDatiRichiesta(datiRichiesta);

        return richiesta;
    }
}
