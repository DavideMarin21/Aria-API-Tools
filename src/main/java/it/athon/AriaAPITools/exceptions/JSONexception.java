package it.athon.AriaAPITools.exceptions;

public class JSONexception extends RuntimeException{
    
    public JSONexception(String errore) {
        super(errore);
    }

    public JSONexception(String errore, Throwable causa) {
        super(errore, causa);
    }
}
