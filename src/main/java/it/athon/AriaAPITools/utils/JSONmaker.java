package it.athon.AriaAPITools.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import com.fasterxml.jackson.annotation.JsonInclude;
import it.athon.AriaAPITools.model.Richiesta;

public class JSONmaker {
    
    public Logger logger = LoggerFactory.getLogger(JSONmaker.class);

    public String creaJSON(Richiesta richiesta) {
        
        try {
            // Inizializzo il motore di Jackson
            ObjectMapper mapper = new ObjectMapper();

            // Faccio in modo che non vengano inclusi i campi nulli
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

            // Trasformo l'oggetto Richiesta in JSON
            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(richiesta);
            logger.info("JSON creato con successo:\n" + json);
            return json;
            
        } catch (Exception e) {
            logger.error("Errore nella creazione del JSON: " + e.getMessage());
            return e.getMessage();
        }

    }
}

