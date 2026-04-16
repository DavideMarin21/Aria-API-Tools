package it.athon.AriaAPITools.utils;

import java.io.InputStream;
import java.util.Properties;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import it.athon.AriaAPITools.exceptions.ConfigException;

public class ConfigLoader {

    // Inizializzo il logger
    private static final Logger logger = LoggerFactory.getLogger(ConfigLoader.class);

    private Properties props = new Properties();

    // Costruttore di default (usa config.properties)
    public ConfigLoader() {
        this("application.properties");
    }

    // Costruttore parametrizzato per massima flessibilità
    public ConfigLoader(String fileName) {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(fileName)) {
            
            // 3. Gestione esplicita del file mancante
            if (input == null) {
                String errorMsg = "Impossibile trovare il file di configurazione: " + fileName;
                logger.error(errorMsg);
                throw new ConfigException(errorMsg);
            }
            
            props.load(input);
            logger.info("File di configurazione '{}' caricato con successo.", fileName);
            
        } catch (Exception e) {
            logger.error("Errore durante il caricamento del file di configurazione: {}", e.getMessage(), e);
            throw new ConfigException("Errore durante il caricamento del file di configurazione: " + e.getMessage());
        }
    }

    public String getProperty(String key) {
        return props.getProperty(key);
    }

    public int getIntProperty(String key, int defaultValue) {
        String value = props.getProperty(key);
        return (value != null) ? Integer.parseInt(value) : defaultValue;
    }

    public boolean getBooleanProperty(String key) {
        return Boolean.parseBoolean(props.getProperty(key, "false"));
    }
}

