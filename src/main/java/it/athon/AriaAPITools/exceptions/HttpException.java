package it.athon.AriaAPITools.exceptions;

public class HttpException extends RuntimeException {
    
    public HttpException(String errore) {
        super(errore);
    }

    public HttpException(String errore, Throwable causa) {
        super(errore, causa);
    }
}
