package it.athon.AriaAPITools.httpClient;


/**
 * Classe per l'invio di messaggi SOAP tramite metodo HTTP Post
 */


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import jakarta.xml.soap.SOAPMessage;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import it.athon.AriaAPITools.exceptions.HttpException;

public class ClientHttp_SOAP {

    private static Logger logger = LoggerFactory.getLogger(ClientHttp_SOAP.class);

    private static final HttpClient client = HttpClient.newBuilder() 
            .version(HttpClient.Version.HTTP_1_1)
            .executor(Executors.newVirtualThreadPerTaskExecutor())
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    private final URI uri;
    private final Map<String, String> headers = new HashMap<>();

    public ClientHttp_SOAP(String baseUrl) {
        this.uri = URI.create(baseUrl);
        logger.debug("Client HTTP creato con URL: {}", baseUrl);
        
        // Header di default per richieste SOAP
        this.headers.put("Content-Type", "text/xml; charset=ISO-8859-1");
        logger.debug("Content-Type: text/xml");
    }

    public ClientHttp_SOAP addHeader(String key, String value) {
        if (value!= null) {
            this.headers.put(key, value);
            logger.debug("Header aggiunto: {} = {}" , key, value);
        }
        return this;
    }

    // Metodo per inviare una richiesta POST
    public String inviaPost(SOAPMessage soapMessage) throws Exception {

        // Converto il SOAPMessage in un array di byte
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        soapMessage.writeTo(outputStream);
        byte[] requestBody = outputStream.toByteArray();
        logger.info("Preparo la richiesta POST verso {}", uri);
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .uri(uri)
                .timeout(Duration.ofSeconds(10))
                .POST(HttpRequest.BodyPublishers.ofByteArray(requestBody));
        
        // Aggiungo gli header disponibili
        headers.forEach(requestBuilder::header);

        HttpRequest request = requestBuilder.build();

        try {
            logger.info("Invio la richiesta tramite HTTP Post");
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            logger.info("Ricevuta la risposta con codice: {}", response.statusCode());

            return gestoreRisposta(response);

        } catch (IOException e) {
            logger.error("Errore di rete durante l'invio della richiesta POST", e);
            throw new HttpException("Errore di connessione durante l'invio della richiesta POST: " + e.getMessage(), e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.error("Il thread è stato interrotto durante la richiesta HTTP", e);
            throw new HttpException("Richiesta HTTP interrotta: " + e.getMessage(), e);
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
            case 500 -> {
                logger.warn("Ricevuto errore 500. Possibile SOAP Fault. Body: {}", response.body());
                throw new HttpException("Errore 500 (SOAP Fault): " + response.body());}
            default -> throw new HttpException("Errore HTTP imprevisto: " + code + " - " + response.body());
        }
    }
    
}
