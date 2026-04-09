package it.athon.AriaAPITools;

import jakarta.xml.soap.SOAPMessage;
import it.athon.AriaAPITools.utils.CreaIdentificaCittadinoRequest;

public class MainTestSEB {

    public static void main(String[] args) {
        
        System.out.println("Inizio test creazione messaggi SOAP SEB ICCE...\n");

        try {
            // 1. Istanzio la classe creatrice
            CreaIdentificaCittadinoRequest creator = new CreaIdentificaCittadinoRequest();

            /* ==========================================================
             * TEST 1: Usa il valore di default (Codice Fiscale)
             * Chiamiamo il metodo passando UN SOLO parametro.
             * ========================================================== */
            System.out.println("=== TEST 1: Ricerca di default (Codice Fiscale) ===");
            SOAPMessage requestCF = creator.createIdentificaCittadinoRequest("RSSMRA80A01H501U", "CodiceFiscale", "55555");
            stampaMessaggio(requestCF);

            /* ==========================================================
             * TEST 2: Specifica esplicitamente il tipo campo "idAna"
             * Chiamiamo il metodo passando DUE parametri.
             * ========================================================== */
            System.out.println("\n=== TEST 2: Ricerca specifica per idAna ===");
            SOAPMessage requestIdAna = creator.createIdentificaCittadinoRequest("1234567890123456", "idAna", "55555");
            stampaMessaggio(requestIdAna);

            /* ==========================================================
             * TEST 3: Specifica esplicitamente il tipo campo "idAssistito"
             * ========================================================== */
            System.out.println("\n=== TEST 3: Ricerca specifica per idAssistito ===");
            SOAPMessage requestIdAssistito = creator.createIdentificaCittadinoRequest("987654321", "idAssistito", "55555");
            stampaMessaggio(requestIdAssistito);

        } catch (Exception e) {
            System.err.println("Si è verificato un errore durante la generazione del messaggio SOAP:");
            e.printStackTrace();
        }
        
        System.out.println("\nFine test.");
    }

    /**
     * Metodo di utilità per stampare il contenuto del messaggio SOAP in console.
     */
    private static void stampaMessaggio(SOAPMessage message) throws Exception {
        // Il metodo writeTo stampa l'intero albero XML sullo stream fornito (System.out)
        message.writeTo(System.out);
        // Aggiungo un a capo extra per rendere la console più leggibile
        System.out.println(); 
    }
}