package it.athon.AriaAPITools;

import java.util.Arrays;
import java.util.List;

import it.athon.AriaAPITools.model.*;
import it.athon.AriaAPITools.utils.*;

public class MainTestJsonDuePrescrizioni {

    public static void main(String[] args) throws Exception{

        System.out.println("Avvio test con DUE prescrizioni...\n");

        // 1. INIZIALIZZO GLI OPERAI
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
        // PRESCRIZIONE NUMERO 1 (Progressivo "1")
        // ==========================================
        PrestazioneSpecialistica prestazione1 = creaPrestazione.creaPrestazioneSpecialistica(
            "0090754", "TEMPO DI PROTROMBINA (PT)", "4"
        );
        ElencoPrestazioni elenco1 = creaElenco.creaElencoPrestazioni(Arrays.asList(prestazione1));
        DatiSensibili sensibili1 = creaSensibili.creaDatiSensibili("Test Registra Prescrizione 1", elenco1);
        DatiAmministrativi amm1 = creaAmm.creaDatiAmministrativi(
            "02", "09", "A", "S", "E", "P", "N", "SI"
        );
        
        // Creo l'oggetto Prescrizione 1
        DatiPrescrizione prescrizione1 = creaPrescrizione.creaPrescrizione("1", amm1, sensibili1);


        // ==========================================
        // PRESCRIZIONE NUMERO 2 (Progressivo "2")
        // ==========================================
        // Immaginiamo che questa abbia un esame diverso, ad esempio del sangue
        PrestazioneSpecialistica prestazione2 = creaPrestazione.creaPrestazioneSpecialistica(
            "90.04.5", "ALANINA AMINOTRASFERASI (ALT/GPT)", "1"
        );
        ElencoPrestazioni elenco2 = creaElenco.creaElencoPrestazioni(Arrays.asList(prestazione2));
        DatiSensibili sensibili2 = creaSensibili.creaDatiSensibili("Esami di routine", elenco2);
        DatiAmministrativi amm2 = creaAmm.creaDatiAmministrativi(
            "01", "08", "C", "N", "E", "U", "N", "NO"
        );
        
        // Creo l'oggetto Prescrizione 2
        DatiPrescrizione prescrizione2 = creaPrescrizione.creaPrescrizione("2", amm2, sensibili2);


        // ==========================================
        // UNISCO LE DUE PRESCRIZIONI NELLA LISTA
        // ==========================================
        // Ecco il punto chiave: mettiamo entrambe le prescrizioni nell'array!
        List<DatiPrescrizione> listaPrescrizioni = Arrays.asList(prescrizione1, prescrizione2);


        // ==========================================
        // CHIUSURA DELL'OGGETTO
        // ==========================================
        DatiCittadino cittadino = creaCittadino.creaDatiCittadino(
            "CTTPSC84D15F205E", "CITTADINO", "PRESCRITTIVO", "M", "030321", "MI"
        );

        // Passo l'intera lista di prescrizioni al costruttore della richiesta
        DatiRichiesta datiRichiesta = creaDatiRichiesta.creaDatiRichiesta("TEST 1", cittadino, listaPrescrizioni);

        DatiOperatore operatore = creaOperatore.creaDatiOperatore(
            "NOMETEST", "COGNOMETEST", "CGNNTS80A01F205P"
        );

        Richiesta richiestaCompleta = creaRichiestaFinale.creaRichiesta(
            "TEST", "TEST", operatore, List.of(datiRichiesta)
        );

        // ==========================================
        // GENERAZIONE JSON
        // ==========================================
        JSONmaker generatore = new JSONmaker();
        String jsonRisultato = generatore.creaJSON(richiestaCompleta);

        System.out.println("--- IL TUO JSON FINALE ---");
        System.out.println(jsonRisultato);
    }
}