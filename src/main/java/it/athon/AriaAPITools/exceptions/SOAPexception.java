package it.athon.AriaAPITools.exceptions;

public class SOAPexception extends RuntimeException{
    
    public SOAPexception(String errore) {
        super(errore);
    }

    public SOAPexception(String errore, Throwable causa) {
        super(errore, causa);
    }
}
