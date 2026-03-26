package it.athon.AriaAPITools.utils;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import it.athon.AriaAPITools.exceptions.ValidazionePrescrizioneException;
import it.athon.AriaAPITools.model.DatiAmministrativi;

public class CreaDatiAmministrativi {

    public Logger logger = LoggerFactory.getLogger(CreaDatiAmministrativi.class);

    public DatiAmministrativi creaDatiAmministrativi(String dataEmissione, String tipologiaPrescrizione, String tipoModulo, String tipoVisita, String flagSuggerita, String flagRicEl, String classePriorita, String flagRipetibile, String generaPromemoria) {

    DatiAmministrativi datiAmministrativi = new DatiAmministrativi();
    
        datiAmministrativi.setDataEmissione(dataEmissione);
        datiAmministrativi.setTipologiaPrescrizione(tipologiaPrescrizione);
        datiAmministrativi.setTipoModulo(tipoModulo);
        datiAmministrativi.setTipoVisita(tipoVisita);
        datiAmministrativi.setFlagSuggerita(flagSuggerita);
        datiAmministrativi.setFlagRicEl(flagRicEl);
        datiAmministrativi.setClassePriorita(classePriorita);
        datiAmministrativi.setFlagRipetibile(flagRipetibile);
        datiAmministrativi.setGeneraPromemoria(generaPromemoria);

        logger.info("Dati Amministrativi: " + datiAmministrativi);

        return datiAmministrativi;
    
    }
    
    public static boolean validazioneDataEmissione(String dataEmissione) {

        /** Verifico se la dataEmissione è nel corretto formato richiesto  */

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        try {
            LocalDate.parse(dataEmissione, formatter);
            return true;
        } catch (DateTimeParseException e) {
            throw new ValidazionePrescrizioneException("Errore validazione: La data di emissione '" + dataEmissione + "' non è nel formato corretto 'yyyyMMdd'.");
        }
        
    }

}

