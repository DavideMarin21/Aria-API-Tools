package it.athon.AriaAPITools.utils;

/**
 * Questa classe si occupa di trasformare un oggetto Richiesta in una stringa JSON formattata
 * Viene utilizzata la libraria Jackson
 * Il JSON viene creato in modo "pulito", senza campi nulli e con una formattazione leggibile
 */

import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import com.fasterxml.jackson.annotation.JsonInclude;

import it.athon.AriaAPITools.exceptions.JSONexception;
import it.athon.AriaAPITools.model.Richiesta;
import it.athon.AriaAPITools.processor.validator.validaJSON;

public class JSONmaker {
    
    private static final Logger logger = LoggerFactory.getLogger(JSONmaker.class);

    // Inizializzo il mapper per costruire il JSON usando la richiesta come stampo
    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    // Metodo per creare il JSON
    public String creaJSON(Richiesta richiesta) throws Exception{
        
        try {
            // Trasformo l'oggetto Richiesta in JSON
            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(richiesta);
            
            // Controllo che il JSON rispetti le specifiche date dal SISS
            validaJSON.validaJsonRichiesta(json);
            
            logger.info("JSON creato con successo! \n" + json);
            return json;
            
        } catch (Exception e) {
            logger.error("Errore nella creazione del JSON: " + e.getMessage());
            throw new JSONexception("Errore nella creazione del JSON: " + e.getMessage());
        }

    }
}

