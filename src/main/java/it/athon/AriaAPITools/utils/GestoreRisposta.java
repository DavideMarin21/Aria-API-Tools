package it.athon.AriaAPITools.utils;

/**
 * Classe utile per verificare l'esito della chiamata HTTP REST
 */

import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.DeserializationFeature;

import it.athon.AriaAPITools.model.DatiPrescrizioneEstratti;
import it.athon.AriaAPITools.model.Risposta;

public class GestoreRisposta {

        private static final Logger logger = LoggerFactory.getLogger(GestoreRisposta.class);

        private final ObjectMapper mapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        public Risposta elaboraJson(String jsonRisposta) throws Exception{

            Risposta risposta = null;
            try {
                risposta = mapper.readValue(jsonRisposta, Risposta.class);
                logger.info("Risposta letta correttamente e decodificata in oggetto Risposta");

            } catch (Exception e) {
                logger.error("Errore nella lettura del JSON di risposta");
                throw new Exception("Errore nella lettura del JSON di risposta");
            }

            String esito = risposta.getEsito();
            if ("OK".equals(esito) || "KO".equals(esito)) {
                logger.info("Esito risposta riconosciuto: {}", esito);
                return risposta;
            } else {
                logger.error("Esito risposta sconosciuto: {}", esito);
                throw new Exception("Esito risposta sconosciuto: " + esito);
            }
        }

        // private List<DatiPrescrizioneEstratti> gestioneOK(Risposta risposta) {

        //     List<DatiPrescrizioneEstratti> listaEstratti = new ArrayList<>();

        //     logger.info("Inizio la gestione del messaggio con esito OK");

        //     if (risposta.getDatiRisposta() != null) {
        //     for (var dati : risposta.getDatiRisposta()) {
                
        //         if (dati.getPrescrizione() != null) {
        //             for (var prescrizione : dati.getPrescrizione()) {
                        
        //                 String nre = prescrizione.getNumeroRicettaElettronica();
        //                 String statoPrescrizione = prescrizione.getStatoPrescrizione();
        //                 logger.info("StatoPrescrizione: {}", statoPrescrizione);
        //                 String base64Pdf = prescrizione.getPromemoriaRE();

        //                 DatiPrescrizioneEstratti estratto = new DatiPrescrizioneEstratti(nre, statoPrescrizione, base64Pdf);
                        
        //                 listaEstratti.add(estratto);
        //             }
        //         }
        //     }
        // }
        
        // return listaEstratti;
            

        // }

        private void gestioneKO(Risposta risposta){

         }
}
