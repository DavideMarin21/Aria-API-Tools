package it.athon.AriaAPITools.utils;

import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;

import it.athon.AriaAPITools.model.DatiPrescrizioneEstratti;
import it.athon.AriaAPITools.model.Risposta;

public class GestioneOK {

    private static final Logger logger = LoggerFactory.getLogger(GestioneOK.class);
    
    public List<DatiPrescrizioneEstratti> elabora(Risposta risposta) {

        List<DatiPrescrizioneEstratti> listaEstratti = new ArrayList<>();

        logger.info("Inizio la gestione del messaggio con esito OK");

        if (risposta.getDatiRisposta() != null) {
            for (var dati : risposta.getDatiRisposta()) {
                
                if (dati.getPrescrizione() != null) {
                    for (var prescrizione : dati.getPrescrizione()) {
                        
                        String nre = prescrizione.getNumeroRicettaElettronica();
                        String statoPrescrizione = prescrizione.getStatoPrescrizione();
                        String base64Pdf = prescrizione.getPromemoriaRE();

                        DatiPrescrizioneEstratti estratto = new DatiPrescrizioneEstratti(nre, statoPrescrizione, base64Pdf);
                        
                        listaEstratti.add(estratto);
                        logger.info("Prescrizione estratta con successo {}", nre);
                    }
                }
            }
        }
        
        return listaEstratti;
    }
    
}
