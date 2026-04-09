// Crea la variabile DatiOperatore necessaria per il JSON
package it.athon.AriaAPITools.utils;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import it.athon.AriaAPITools.model.DatiOperatore;

public class CreaDatiOperatori {

    
    private static final Logger logger = LoggerFactory.getLogger(CreaDatiOperatori.class);


    public DatiOperatore creaDatiOperatore(String nomeOperatore, String cognomeOperatore, String cfOperatore) {

        DatiOperatore datiOperatore = new DatiOperatore();

        datiOperatore.setNomeOperatore(nomeOperatore);
        datiOperatore.setCognomeOperatore(cognomeOperatore);
        datiOperatore.setCodiceFiscaleOperatore(cfOperatore);

        logger.info("Creato Operatore con i seguenti valori: {} {} {}", cfOperatore, cognomeOperatore, nomeOperatore);

        return datiOperatore;
    }
    
}
