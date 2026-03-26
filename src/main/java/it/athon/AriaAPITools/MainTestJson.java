package it.athon.AriaAPITools;

import java.util.Arrays;
import java.util.List;

// Importiamo i modelli
import it.athon.AriaAPITools.model.*;
// Importiamo le funzioni (i "costruttori")
import it.athon.AriaAPITools.utils.*;
import it.athon.AriaAPITools.utils.ClientRestPrescrizione;

public class MainTestJson {

    public static void main(String[] args) {

        ConfigLoader config = new ConfigLoader();
        System.out.println("Avvio test generazione JSON indipendente...\n");

        // ==========================================
        // 1. INIZIALIZZO TUTTI GLI "OPERAI" (Le classi Crea...)
        // ==========================================
        CreaPrestazioniSpecialistiche creaPrestazione = new CreaPrestazioniSpecialistiche();
        CreaElencoPrestazioni creaElenco = new CreaElencoPrestazioni();
        CreaDatiSensibili creaSensibili = new CreaDatiSensibili();
        CreaDatiAmministrativi creaAmm = new CreaDatiAmministrativi();
        CreaPrescrizione creaPrescrizione = new CreaPrescrizione();
        CreaDatiCittadino creaCittadino = new CreaDatiCittadino();
        CreaDatiRichiesta creaDatiRichiesta = new CreaDatiRichiesta();
        CreaDatiOperatori creaOperatore = new CreaDatiOperatori();
        CreaRichiesta creaRichiestaFinale = new CreaRichiesta();


        // ==========================================
        // 2. COSTRUISCO I PEZZI PARTENDO DAL PIÙ PICCOLO
        // ==========================================

        // --- PRESTAZIONI ---
        PrestazioneSpecialistica prestazione1 = creaPrestazione.creaPrestazioneSpecialistica(
            "0090754", 
            "TEMPO DI PROTROMBINA (PT)", 
            "4"
        );
        // Le prestazioni vanno in una lista
        List<PrestazioneSpecialistica> listaPrestazioni = Arrays.asList(prestazione1);

        // --- ELENCO PRESTAZIONI ---
        ElencoPrestazioni elenco = creaElenco.creaElencoPrestazioni(listaPrestazioni);

        // --- DATI SENSIBILI ---
        DatiSensibili datiSensibili = creaSensibili.creaDatiSensibili("Test Registra Prescrizione", elenco);

        // --- DATI AMMINISTRATIVI ---
        DatiAmministrativi datiAmm = creaAmm.creaDatiAmministrativi(
            "20140904", "02", "09", "A", "S", "E", "P", "N", "SI"
        );

        // --- PRESCRIZIONE ---
        Prescrizione prescrizione = creaPrescrizione.creaPrescrizione("1", datiAmm, datiSensibili);
        // Anche le prescrizioni vanno in una lista (il JSON richiede un array)
        List<Prescrizione> listaPrescrizioni = Arrays.asList(prescrizione);

        // --- DATI CITTADINO ---
        DatiCittadino cittadino = creaCittadino.creaDatiCittadino(
            "CTTPSC84D15F205E", "CITTADINO", "PRESCRITTIVO", "M", "030321", "MI"
        );

        // --- DATI RICHIESTA ---
        DatiRichiesta datiRichiesta = creaDatiRichiesta.creaDatiRichiesta("TEST 1", cittadino, listaPrescrizioni);

        // --- DATI OPERATORE ---
        DatiOperatore operatore = creaOperatore.creaDatiOperatore(
            "NOMETEST", "COGNOMETEST", "CGNNTS80A01F205P"
        );


        // ==========================================
        // 3. ASSEMBLAGGIO FINALE DELL'OGGETTO ROOT
        // ==========================================
        Richiesta richiestaCompleta = creaRichiestaFinale.creaRichiesta(
            "TEST", 
            "TEST", 
            operatore, 
            datiRichiesta
        );


        // ==========================================
        // 4. GENERAZIONE DEL JSON CON JACKSON
        // ==========================================
        JSONmaker generatore = new JSONmaker();
        String jsonRisultato = generatore.creaJSON(richiestaCompleta);

        System.out.println("--- IL TUO JSON FINALE ---");
        System.out.println(jsonRisultato);
        System.out.println("--------------------------");

        // Creiamo il client passandogli la configurazione
        ClientRestPrescrizione client = new ClientRestPrescrizione();
        
        // Inviamo: il client saprà da solo URL, Timeout e Content-Type
        client.invia(jsonRisultato);
    }
}