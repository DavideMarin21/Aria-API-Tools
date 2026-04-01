package it.athon.AriaAPITools.exceptions;

public class ConfigException extends RuntimeException{

    public ConfigException(String messaggio) {
        super(messaggio);
    }

    public ConfigException(String messaggio, Throwable causa) {
        super(messaggio, causa);
    }
}
