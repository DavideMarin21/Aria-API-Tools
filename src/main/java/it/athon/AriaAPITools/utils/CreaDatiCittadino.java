package it.athon.AriaAPITools.utils;

import it.athon.AriaAPITools.model.DatiCittadino;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import it.athon.AriaAPITools.exceptions.ValidazionePrescrizioneException;

public class CreaDatiCittadino {

    /** Posso avere due tipi di caso:
     * 1) tipoModulo = 09: in questo caso devo avere tutti i dati del cittadino
     * 2) tipoModulo = 05: in questo caso basta avere solo il codice fiscale del cittadino
     */ 

    public Logger logger = LoggerFactory.getLogger(CreaDatiCittadino.class);

    public DatiCittadino gesticiCreazione(String tipoModulo, String cfCittadino, String cognomeCittadino, String nomeCittadino, String sessoCittadino, String ASLCittadino, String provCittadino) {
        if (tipoModulo.equals("09")) {
            logger.info("Creazione dati cittadino per tipo modulo 09");
            return creaDatiCittadino(cfCittadino, cognomeCittadino, nomeCittadino, sessoCittadino, ASLCittadino, provCittadino);
        }

        else if (tipoModulo.equals("RUR 2005")) {
            logger.info("Creazione dati cittadino per tipo modulo RUR 2005");
            return creaDatiCittadino(cfCittadino);        
        }
        else {
            logger.error("tipoModulo non riconosciuto: " + tipoModulo);
            throw new ValidazionePrescrizioneException("tipoModulo non riconosciuto: " + tipoModulo);
        }
    }

    public DatiCittadino creaDatiCittadino(String cfCittadino, String cognomeCittadino, String nomeCittadino, String sessoCittadino, String ASLCittadino, String provCittadino) {

        validazioneCodiceFiscale(cfCittadino);

        if (cognomeCittadino == null || cognomeCittadino.isEmpty()) {
            throw new ValidazionePrescrizioneException("Errore validazione: Il cognome è un dato obbligatorio");
        }

        if (nomeCittadino == null || nomeCittadino.isEmpty()) {
            throw new ValidazionePrescrizioneException("Errore validazione: Il nome è un dato obbligatorio");
        }
        DatiCittadino cittadino = new DatiCittadino();

        cittadino.setCodiceFiscale(cfCittadino);
        cittadino.setCognome(cognomeCittadino);
        cittadino.setNome(nomeCittadino);
        cittadino.setSesso(sessoCittadino);
        cittadino.setASLAssistito(ASLCittadino);
        cittadino.setProvAssistito(provCittadino);

        return cittadino;

    }

    public DatiCittadino creaDatiCittadino(String cfCittadino) {

       validazioneCodiceFiscale(cfCittadino); 

        DatiCittadino cittadino = new DatiCittadino();

        cittadino.setCodiceFiscale(cfCittadino);

        return cittadino;
    }

    private void validazioneCodiceFiscale (String cfCittadino) {

        if (cfCittadino == null || cfCittadino.isEmpty()) {
            throw new ValidazionePrescrizioneException("Errore validazione: Il codice fiscale è obbligatorio");
        }

        if (cfCittadino.length() !=16) {
            throw new ValidazionePrescrizioneException("Errore validazione: Il Codice Fiscale '" + cfCittadino + "' non è lungo 16 caratteri.");
        }
    }
    
}
