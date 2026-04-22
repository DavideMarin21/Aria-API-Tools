package it.athon.AriaAPITools.httpClient;

/**
 * Classe per la creazione di un client HTTP per l'invio di richieste XML/SOAP e la ricezione delle risposte.
 * Utilizza la libreria inclusa con Java: HttpClient
 * In ingresso abbiamo l'url verso dove inviare l'XML
 * In caso di esito positivo resitutuisce il body della risposta, in caso contrario restituisce l'errore ricevuto
 */


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.Executors;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import jakarta.xml.soap.SOAPMessage;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import it.athon.AriaAPITools.exceptions.HttpException;

public class ClientHttp_SOAP {

    /**
     * Classe per la creazione di un client HTTP
     * @param baseUrl indirizzo verso cui inviare il SOAP
     * @throws HttpException eccezzione in caso di errore nell'invio del SOAP
     */

    private static Logger logger = LoggerFactory.getLogger(ClientHttp_SOAP.class);

    // Inizializzo il client HTTP
    private static final HttpClient client = HttpClient.newBuilder() 
            // Utilizzo la versione HTTP 1.1 che è quella utilizzata dal SISS
            .version(HttpClient.Version.HTTP_1_1)
            // Utilizzo i virtual threads in modo da saturare meno la RAM
            .executor(Executors.newVirtualThreadPerTaskExecutor())
            // Imposto un limite massimo per contattare il server senno sollevo un'eccezione -> NON è configurabile da application properties
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    private final URI uri;

    // Inizializzo la mappa per gli headers della chiamata HTTP
    private final Map<String, String> headers = new HashMap<>();

    // Costruttore del client dove accetto l'Url e setto dei header di default per la richiesta HTTP Rest con JSON
    public ClientHttp_SOAP(String baseUrl) {
        this.uri = URI.create(baseUrl);
        logger.debug("Client HTTP creato con URL: {}", baseUrl);
        
        // Header di default per richieste SOAP
        this.headers.put("Content-Type", "text/xml; charset=ISO-8859-1");
        logger.debug("Content-Type: text/xml");
    }

    // Metodo per aggiungere header custom oltre a quelli "classici"
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

        // Provo a inviare il SOAP senno sollevo un'eccezione
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

    // Metodo per gestire la risposta del client -> DA MODIFICARE PER RENDERE PIù ROBUSTA SOPRATUTTO LA PARTE DI ERRORE
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
