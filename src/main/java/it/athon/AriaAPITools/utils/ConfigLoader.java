package it.athon.AriaAPITools.utils;

import java.io.InputStream;
import java.util.Properties;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import it.athon.AriaAPITools.exceptions.ConfigException;

public class ConfigLoader {

    // Inizializzo il logger
    public Logger logger = LoggerFactory.getLogger(ConfigLoader.class);

    private Properties props = new Properties();

    public ConfigLoader() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input != null) {
                props.load(input);
                logger.info("File di configurazione caricato con successo.");
            }
        } catch (Exception e) {
            logger.error("Errore durante il caricamento del file di configurazione: " + e.getMessage());
            throw new ConfigException("Errore durante il caricamento del file di configurazione: " + e.getMessage());
        }
    }

    public String getProperty(String key, String defaultValue) {
        return props.getProperty(key, defaultValue);
    }

    public int getIntProperty(String key, int defaultValue) {
        String value = props.getProperty(key);
        return (value != null) ? Integer.parseInt(value) : defaultValue;
    }

    public boolean getBooleanProperty(String key) {
        return Boolean.parseBoolean(props.getProperty(key, "false"));
    }
}

