// Crea la variabile DatiOperatore necessaria per il JSON
package it.athon.AriaAPITools.utils;

import it.athon.AriaAPITools.model.DatiOperatore;

public class CreaDatiOperatori {

    public DatiOperatore creaDatiOperatore(String nomeOperatore, String cognomeOperatore, String cfOperatore) {

        DatiOperatore datiOperatore = new DatiOperatore();

        datiOperatore.setNomeOperatore(nomeOperatore);
        datiOperatore.setCognomeOperatore(cognomeOperatore);
        datiOperatore.setCodiceFiscaleOperatore(cfOperatore);

        return datiOperatore;
    }
    
}
