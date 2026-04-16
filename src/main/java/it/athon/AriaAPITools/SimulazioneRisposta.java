package it.athon.AriaAPITools;

import it.athon.AriaAPITools.utils.GestoreRisposta;
import it.athon.AriaAPITools.model.DatiPrescrizioneEstratti;
import java.util.List;

public class SimulazioneRisposta{

    public static void main(String[] args) {
        
        // 1. Simulo un JSON in ingresso con DUE prescrizioni
        String jsonMock = """
        {
            "esito": "OK",
            "datiRisposta": [
                {
                    "idRisposta": "TEST 1",
                    "datiCittadino": {
                        "codiceFiscale": "CTTPSC84D15F205E"
                    },
                    "prescrizioni": [
                        {
                            "numeroRicettaElettronica": "0300TEST001",
                            "promemoriaRE": "JVBERi0xLjQKJcOkw7zDtsOfCjIgMCBvYmoKPDwvTGVuZ3Ro... (PDF 1)",
                            "statoPrescrizione" : "01"
                        },
                        {
                            "numeroRicettaElettronica": "0300TEST002",
                            "statoPrescrizione" : "09",
                            "promemoriaRE": "JVBERi0xLjQKJcOkw7zDtsOfCjIgMCBvYmoKPDwvTGVuZ3Ro... (PDF 2)"
                        },
                        {
                            "numeroRicettaElettronica": "0300TEST003",
                            "promemoriaRE": "JVBERi0xLjQKJcOkw7zDtsOfCjIgMCBvYmoKPDwvTGVuZ3Ro... (PDF 2)",
                            "statoPrescrizione" : "06"
                        },
                        {
                            "numeroRicettaElettronica": "0300TEST004",
                            "promemoriaRE": "JVBERi0xLjQKJcOkw7zDtsOfCjIgMCBvYmoKPDwvTGVuZ3Ro... (PDF 2)",
                            "statoPrescrizione" : "02"
                        },
                        {
                            "numeroRicettaElettronica": "0300TEST005",
                            "promemoriaRE": "JVBERi0xLjQKJcOkw7zDtsOfCjIgMCBvYmoKPDwvTGVuZ3Ro... (PDF 2)",
                            "statoPrescrizione" : "03"
                        }
                    ]
                }
            ]
        }
        """;

        // NOTA: se il tuo POJO si aspetta la chiave "prescrizione" al singolare,
        // ricordati di cambiarla nel JSON qui sopra!

        GestoreRisposta gestore = new GestoreRisposta();

        try {
            System.out.println("--- AVVIO TEST ESTRAZIONE DATI ---");
            
            // 2. Chiamo il tuo metodo passandogli il JSON finto
            List<DatiPrescrizioneEstratti> datiProntiPerHL7 = gestore.elaboraJson(jsonMock);

            // 3. Stampo i risultati simulando quello che farai per l'HL7
            System.out.println("\\n--- DATI ESTRATTI CON SUCCESSO (" + datiProntiPerHL7.size() + " trovati) ---");
            
            for (int i = 0; i < datiProntiPerHL7.size(); i++) {
                DatiPrescrizioneEstratti estratto = datiProntiPerHL7.get(i);
                
                System.out.println("Prescrizione #" + (i + 1));
                System.out.println("  > NRE    : " + estratto.getNre());
                
                // Stampo solo i primi 20 caratteri del Base64 per non intasare la console
                String base64 = estratto.getPdfBase64();
                String base64Troncato = (base64 != null && base64.length() > 20) 
                        ? base64.substring(0, 20) + "..." 
                        : base64;
                
                System.out.println("  > Base64 : " + base64Troncato);
                
                System.out.println("  > StatoPrescrizione : " + estratto.getstatoPrescrizione());
                System.out.println("----------------------------------------");
            }

        } catch (Exception e) {
            System.err.println("TEST FALLITO: " + e.getMessage());
            e.printStackTrace();
        }
    }
}