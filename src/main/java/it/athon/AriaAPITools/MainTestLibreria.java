package it.athon.AriaAPITools;

import jakarta.xml.soap.SOAPMessage;
import it.athon.AriaAPITools.utils.CreaIdentificaCittadinoRequest;
import it.athon.AriaAPITools.httpClient.ClientHttp_SOAP;

public class MainTestLibreria {

    public static void main(String[] args) {
        
        System.out.println("=== INIZIO TEST INTEGRAZIONE SEB ICCE ===\n");

        try {
            // =================================================================
            // FASE 1: COSTRUZIONE DEL MESSAGGIO SOAP TRAMITE IL BUILDER
            // =================================================================
            System.out.println("1. Creazione del messaggio SOAP in corso...");
            CreaIdentificaCittadinoRequest builder = new CreaIdentificaCittadinoRequest();

            SOAPMessage messaggio = builder.createBaseMessage();
            
            // Aggiungo l'Header con un token fittizio
            messaggio = builder.addHeader(messaggio, "TokenDiProva123");
            
            // Aggiungo il Body (Proviamo con il Codice Fiscale)
            messaggio = builder.addBodyIdentificaCittaddino_CF(messaggio, "RSSMRA80A01H501U", "123456789");
            
            // Aggiungo gli attributi di ricerca obbligatori
            messaggio = builder.addAttributiRicerca(messaggio, "1", "4", "100");

            // Salvo definitivamente le modifiche
            messaggio = builder.salvaMessaggio(messaggio);

            // Stampo a video il messaggio generato per controllo visivo
            System.out.println("\n--- SOAP Request Generata ---");
            messaggio.writeTo(System.out);
            System.out.println("\n-----------------------------\n");


            // =================================================================
            // FASE 2: INVIO DEL MESSAGGIO TRAMITE IL CLIENT HTTP
            // =================================================================
            // Imposta qui l'URL del tuo script PHP locale o l'URL di collaudo
            String mockUrl = "http://localhost/xml.php"; 
            
            System.out.println("2. Inizializzazione Client HTTP verso: " + mockUrl);
            ClientHttp_SOAP httpClient = new ClientHttp_SOAP(mockUrl);

            // (Opzionale) Se servisse aggiungere un header custom al volo, potresti farlo così:
            // httpClient.addHeader("Custom-Header", "Valore");

            System.out.println("3. Invio della richiesta...");
            String rispostaXml = httpClient.inviaPost(messaggio);


            // =================================================================
            // FASE 3: LETTURA DELLA RISPOSTA
            // =================================================================
            System.out.println("\n=== RISPOSTA DEL SERVER RICEVUTA ===");
            System.out.println(rispostaXml);
            System.out.println("====================================");

        } catch (Exception e) {
            System.err.println("\n[ERRORE CRITICO] Si è verificata un'eccezione durante il test:");
            e.printStackTrace();
        }

        System.out.println("\n=== FINE TEST ===");
    }
}