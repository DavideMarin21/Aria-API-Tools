package it.athon.AriaAPITools.exceptions;

public class CreazioneRichiestaException extends RuntimeException {
    
    public CreazioneRichiestaException(String errore) {
        super(errore);
    }

    public CreazioneRichiestaException(String errore, Throwable causa) {
        super(errore, causa);
    }
}
