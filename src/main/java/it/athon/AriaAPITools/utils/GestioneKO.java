package it.athon.AriaAPITools.utils;

/**
 * Classe per gestire l'esito KO della chiamata HTTP REST per quanto riguarda le chiamate di prescrizione JSON
 * Restituisce il codice errore la la sua descrizone
 */
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import it.athon.AriaAPITools.model.Risposta;
import it.athon.AriaAPITools.model.DatiErroreEstratti;

public class GestioneKO {

    private static final Logger logger = LoggerFactory.getLogger(GestioneKO.class);
    
    public DatiErroreEstratti elabora(Risposta risposta) {

        logger.info("Inizio la gestione del messaggio con esito KO");

        String codiceErrore = risposta.getCodiceErrore();
        String descErrore = risposta.getDescErrore();

        logger.warn("Estratto Errore. Codice: {} - Descrizione: {}", codiceErrore, descErrore);

        return new DatiErroreEstratti(codiceErrore, descErrore);
    }
    
}
