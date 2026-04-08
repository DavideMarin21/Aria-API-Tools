package it.athon.AriaAPITools.httpClient;

/**
 * Classe per la creazione di un client HTTP per l'invio di richieste e la ricezione delle risposte
 * In questo momento supporta il oggetti JSON
 */

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import it.athon.AriaAPITools.exceptions.HttpException;

public class ClientHttp_JSON {

    public Logger logger = LoggerFactory.getLogger(ClientHttp_JSON.class);

    private static final HttpClient client = HttpClient.newBuilder() 
            .version(HttpClient.Version.HTTP_1_1)
            .executor(Executors.newVirtualThreadPerTaskExecutor())
            .connectTimeout(Duration.ofSeconds(10))
            .build();
    
    private final String baseUrl;
    private final Map<String, String> headers = new HashMap<>();

    public ClientHttp_JSON(String baseUrl) {
        this.baseUrl = baseUrl;
        logger.debug("Client HTTP creato con URL: " + baseUrl);
    }

    // Questo metodo permette di aggiungere un header alla richiesta HTTP
    public ClientHttp_JSON addHeader(String key, String value) {
        if (value!= null) {
            this.headers.put(key, value);
            logger.debug("Header aggiunto: " + key + " = " + value);
        }
        return this;
    }

    // Metodo per inviare una richiesta POST
    public String inviaPost(String jsonPayload) throws Exception {
        logger.info("Preparo la richiesta POST");
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl))
                .timeout(Duration.ofSeconds(10))
                .POST(HttpRequest.BodyPublishers.ofString(jsonPayload));
        
        // Aggiungo gli header disponibili
        headers.forEach(requestBuilder::header);

        HttpRequest request = requestBuilder.build();

        try {
            logger.info("Invio la richiesta tramite HTTP Post");
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            logger.info("Ricevuta la risposta con codice: " + response.statusCode());

            return gestoreRisposta(response);
        } catch (Exception e) {
            logger.error("Errore dutante l'invio del messaggio tramite HTTP POST");
            throw new HttpException("Errore durante l'invio della richiesta POST: " + e.getMessage(), e);
        }
    }

    private String gestoreRisposta(HttpResponse<String> response) throws Exception {
        int code = response.statusCode();

        if (code >= 200 && code < 300) {
            return response.body();
        }

        else switch (code) {
            case 401 -> throw new HttpException("Errore 401: Token non valido o scaduto.");
            case 403 -> throw new HttpException("Errore 403: Permessi insufficienti.");
            case 404 -> throw new HttpException("Errore 404: Endpoint non trovato.");
            case 500 -> throw new HttpException("Errore 500: Errore interno del server regionale.");
            default -> throw new HttpException("Errore HTTP imprevisto: " + code + " - " + response.body());
        }
    }
}
