package it.athon.AriaAPITools.exceptions;

public class ValidazionePrescrizioneException extends RuntimeException {
    
    public ValidazionePrescrizioneException(String errore) {
        super(errore);
    }

    public ValidazionePrescrizioneException(String errore, Throwable causa) {
        super(errore, causa);
    }
}
