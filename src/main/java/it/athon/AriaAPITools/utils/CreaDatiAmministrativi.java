package it.athon.AriaAPITools.utils;


/**
 * Questa classe crea l'oggetto DatiAmministrativi
 * A seconda dello scenario in cui ci troviamo gestisce la creazione dei dati amministrativi in modo diverso
 */

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


        //Validazione dei dati amministrativi
        //validazioneDataEmissione(dataEmissione);
        validazioneTipologiaPrescrizione(tipologiaPrescrizione);
        validazioneTipoModulo(tipoModulo);
        validazioneTipoVisita(tipoVisita);
        validazioneFlagSuggerita(flagSuggerita);
        validazioneFlagRicEl(flagRicEl);


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
    
//    private static boolean validazioneDataEmissione(String dataEmissione) {
//
//        /** Verifico se la dataEmissione è nel corretto formato richiesto  */
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
//
//        try {
//            LocalDate.parse(dataEmissione, formatter);
//            return true;
//        } catch (DateTimeParseException e) {
//            throw new ValidazionePrescrizioneException("Errore validazione: La data di emissione '" + dataEmissione + "' non è nel formato corretto 'yyyyMMdd'.");
//        }
//        
//    }

    private void validazioneTipologiaPrescrizione(String tipologiaPrescrizione) {

        /** Verifico se la tipologia di prescrizione è valida:
         * 01: Prescrizione farmaceutica
         * 02: Prescrizione specialistica
         * 03: Prescrizione ricovero
         */

        if (tipologiaPrescrizione.equals("01") || tipologiaPrescrizione.equals("02") || tipologiaPrescrizione.equals("03")) {
            logger.info("Tipologia prescrizione valida");
        
        } else {
            throw new ValidazionePrescrizioneException("Tipologia prescrizione non supportata");
        }
    }

    private void validazioneTipoModulo(String tipoModulo) {

        /** Verifico se il tipo di modulo è supportato
         * 05: Modulo personale
         * 09: Modulo RUR 2005
         */

        if (tipoModulo.equals("05") || tipoModulo.equals("09")) {
            logger.info("Tipo modulo valido");
        }
        else {
            throw new ValidazionePrescrizioneException("Tipo modulo non supportato");
        }
    }

    private void validazioneTipoVisita(String tipoVisita) {

        /** Verifico se il tipo di visita è supportato
         * A: Visita ambulatoriale
         * D: Visita domicialiare
         */
        if (tipoVisita.equals("A") || tipoVisita.equals("D")) {
            logger.info("Tipo visita valido");
        }
        else {
            throw new ValidazionePrescrizioneException("Tipo visita non supportato");
        }
    }

    private void validazioneFlagSuggerita(String flagSuggerita) {

        /** Verifico se il flag suggerita è valido
         * S: Si
         * N: No
         */

        if (flagSuggerita.equals("S") || flagSuggerita.equals("N")) {
            logger.info("Flag valido");
        }
        else {
            throw new ValidazionePrescrizioneException("Flag sbagliato");
        }
    }

    private void validazioneFlagRicEl(String flagRicEl) {

        /** Verifico se il flag è valido
         * C: Ricetta cartacea
         * E: Ricetta elettronica
         */

        if (flagRicEl.equals("C") || flagRicEl.equals("E")) {
            logger.info("Flag valido");
        }
        else {
            throw new ValidazionePrescrizioneException(flagRicEl);
        }
    }
}

