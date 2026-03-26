package it.athon.AriaAPITools.utils;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.athon.AriaAPITools.exceptions.ValidazionePrescrizioneException;

public class ClientRestPrescrizione {
    
    private final ConfigLoader config;
    public Logger logger = LoggerFactory.getLogger(ClientRestPrescrizione.class);
    

    public ClientRestPrescrizione() {
        this.config = new ConfigLoader();
    }

    public void invia(String prescrizioneJSON) {

        // Carico i parametri di configurazione
        String url = config.getProperty("rest.url", "https://api.test.it/v1/prescrizioni");
        String contentType = config.getProperty("rest.content.type", "application/json");
        int timeoutSeconds = config.getIntProperty("rest.timeout", 10);
        String dataSetVersion = config.getProperty("rest.dataset.version", "1.0");
        String mod = config.getProperty("rest.mod", "WS");
        
        // Inizializzo il client HTTP
        HttpClient client = HttpClient.newBuilder()

        // Configuro il timeout
                .connectTimeout(Duration.ofSeconds(timeoutSeconds))
                .build();

        try {
            // Costruisco la richiesta HTTP
            HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .timeout(Duration.ofSeconds(timeoutSeconds))
                    .header("Content-Type", contentType)
                    .header("dataSetVersion", dataSetVersion)
                    .header("mod", mod)
                    .POST(HttpRequest.BodyPublishers.ofString(prescrizioneJSON));
            
            HttpRequest richiesta = requestBuilder.build();

            logger.info("Invio REST: " + richiesta);

            logger.info("[REST] Inviando a: " + url + " (Timeout: " + timeoutSeconds + "s)");
            
            HttpResponse<String> risposta = client.send(richiesta, HttpResponse.BodyHandlers.ofString());

            logger.info("[REST] Risposta ricevuta: " + risposta.statusCode());
            
        } catch (Exception e) {
            logger.error("[REST] Errore durante l'invio della prescrizione: " + e.getMessage());
            throw new ValidazionePrescrizioneException("Errore durante l'invio della prescrizione: " + e.getMessage(), e);
        }
    }

}
