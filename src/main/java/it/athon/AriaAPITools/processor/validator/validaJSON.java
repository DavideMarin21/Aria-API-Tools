package it.athon.AriaAPITools.processor.validator;

/**
 * Questa classe permette di validare il JSON creato, verificando che contenga i campi richiesti a seconda dei dati presenti
 */
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class validaJSON {

    public Logger logger = LoggerFactory.getLogger(validaJSON.class);

    private static final ObjectMapper mapper = new ObjectMapper();
    
    public static void validaJsonRichiesta(String jsonString) throws Exception {

        JsonNode root = mapper.readTree(jsonString);

        // Validazione dei campi appl e idStruttura

        if (!root.has("appl")) {
            throw new Exception("JSON non valido: campo obbligatorio mancante: appl");
        }

        if (!root.has("idStruttura")) {
            throw new Exception("JSON non valido: campo obbligatorio mancante: idStruttura");
        }

        // Validazione del campo relativo all'operatore
        if (!root.has("datiOperatore")) {
            throw new Exception("JSON non valido: campo obbligatorio mancante: datiOperatore");
        }
        else {
            JsonNode operatore = root.path("datiOperatore");
            if (!operatore.has("nomeOperatore")) {
                throw new Exception("JSON non valido: campo obbligatorio mancante: nomeOperatore");
            }
            if (!operatore.has("cognomeOperatore")) {
                throw new Exception("JSON non valido: campo obbligatorio mancante: cognomeOperatore");
            }
            if (!operatore.has("codiceFiscaleOperatore")) {
                throw new Exception("JSON non valido: campo obbligatorio mancante: codiceFiscaleOperatore");
            }
        }
        
        // Validazione del campo relativo a datiRichiesta
        if (!root.has("datiRichiesta")) {
            throw new Exception("JSON non valido: campo obbligatorio mancante: datiRichiesta");
        }
        else {
            JsonNode datiRichiesta = root.path("datiRichiesta");
            for (JsonNode foglia : datiRichiesta) {
                JsonNode id = foglia.path("idRichiesta");
                if (id.isMissingNode()) {
                    throw new Exception("JSON non valido: campo obbligatorio mancante: idRichiesta");
                }
                JsonNode cittadino = foglia.path("datiCittadino");

                if (cittadino.isMissingNode()) {
                    throw new Exception("JSON non valido: campo obbligatorio mancante: datiCittadino");
                }
                JsonNode prescrizioni = foglia.path("prescrizioni");

                String tipoRicetta = "";
                // A seconda del tipo di ricetta, i campi del cittadino cambiano
                if (prescrizioni.isArray() && !prescrizioni.isEmpty()) {
                    JsonNode primaPrescrizione = prescrizioni.get(0);
                    JsonNode datiAdmin = primaPrescrizione.path("datiAmministrativi");
                    if (datiAdmin.has("tipoRicetta")) {
                        tipoRicetta = datiAdmin.get("tipoRicetta").asText();
                    }
                }
                validaCittadino(cittadino, tipoRicetta);
                validaPrescrizioni(prescrizioni);
            }

        }
    }

    private static void validaCittadino(JsonNode cittadino, String tipoRicetta) throws Exception {

        // Regola fissa tipoModulo = 09 -> Nome e Cognome obbligatori

        if (!cittadino.has("nome")) {
            throw new Exception ("JSON non valido: campo obbligatorio mancante: nome cittadino");
        }
        if (!cittadino.has("cognome")) {
            throw new Exception("JSON non valido: campo obbligatorio mancante: cognome cittadino");
        }

        // Ora guardo il tipo di ricetta:
        // tipoRicetta vuota -> Assistito del SSN/SSR -> Codice Fiscale obbligatorio
        if (tipoRicetta.isEmpty()) {
            if (!cittadino.has("codiceFiscale")) {
                throw new Exception("JSON non valido: campo obbligatorio mancante: codiceFiscale cittadino");
            }
        } else if (tipoRicetta.equals("NA") || tipoRicetta.equals("ND")) {
            // Assistito SASN Italiano -> Codice fiscale, numero tessera sanitaria e società di navigazione obbligatori
            if (!cittadino.has("codiceFiscale")) {
                throw new Exception("JSON non valido: campo obbligatorio mancante: codiceFiscale cittadino per ricetta NA/ND");
            }
            if (!cittadino.has("numTessSasn")) {
                throw new Exception("JSON non valido: campo obbligatorio mancante: numTessSasn per ricetta NA/ND");
            }
            if (!cittadino.has("socNavigaz")) {
                throw new Exception("JSON non valido: campo obbligatorio mancante: socNavigaz per ricetta NA/ND");
            }
        } else if (tipoRicetta.equals("ST")) {
            // Assistito STP -> idCittadinoSTP obbligatorio
            if (!cittadino.has("idCittadinoSTP")) {
                throw new Exception("idCittadinoSTP obbligatorio per tipoRicetta ST");
            }
        } else if (tipoRicetta.equals("UE") || tipoRicetta.equals("EE") || tipoRicetta.equals("NE") || tipoRicetta.equals("NX")) {
            // Assistito estero -> numero identificativo persona, istituzione di appartenenza, data di nascita, 
            // sigla stato estero, numero tessera europea, data scadena tessera europea dati obbligatori
            if (!cittadino.has("numIdentPers")) {
                throw new Exception("JSON non valido: campo obbligatorio mancante: numIdentPers per ricetta UE/EE/NE/NX");
            }
            if (!cittadino.has("istituzCompetente")) {
                throw new Exception("JSON non valido: campo obbligatorio mancante: istituzCompetente per ricetta UE/EE/NE/NX");
            }
            if (!cittadino.has("dataNascitaAssistEstera")) {
                throw new Exception("JSON non valido: campo obbligatorio mancante: dataNascitaAssistEstera per ricetta UE/EE/NE/NX");
            }
            if (!cittadino.has("siglastatoEstero")) {
                throw new Exception("JSON non valido: campo obbligatorio mancante: siglastatoEstero per ricetta UE/EE/NE/NX");
            }
            if (!cittadino.has("numeroTesseraEuropea")) {
                throw new Exception("JSON non valido: campo obbligatorio mancante: numeroTesseraEuropea per ricetta UE/EE/NE/NX");
            }
            if (!cittadino.has("dataScadenzaTesseraEuropea")) {
                throw new Exception("JSON non valido: campo obbligatorio mancante: dataScadenzaTesseraEuropea per ricetta UE/EE/NE/NX");
            }
        }
    }

    private static void validaPrescrizioni (JsonNode prescrizioni) throws Exception {
        if (!prescrizioni.isArray() || prescrizioni.isEmpty()) return;

        for (JsonNode prescrizione : prescrizioni) {
            if (!prescrizione.has("progressivoPrescrizione")) {
                throw new Exception("Progressivo prescrizione mancante");
            }

            JsonNode admin = prescrizione.path("datiAmministrativi");
            if (!admin.has("tipoModulo") || !admin.get("tipoModulo").asText().equals("09")) {
                throw new Exception("Questo validatore supporta solo tipoModulo = 09");
            }

            //datiAmminstratore -> tipologia Prescrizione, tipo visita, flag ricetta elettronica, 
            // classe priorità, genera promemoria dati obbligatori
            if (!admin.has("tipologiaPrescrizione")) {
                throw new Exception("JSON non valido: campo obbligatorio mancante: tipologiaPrescrizione");
            }
            if (!admin.has("tipVisita")) {
                throw new Exception("JSON non valido: campo obbligatorio mancante: tipoVisita");    
            }
            if (!admin.has("flagRicEl")) {
                throw new Exception("JSON non valido: campo obbligatorio mancate: flagRiceEl");
            }
            if (!admin.has("classePriorità")) {
                throw new Exception("JSON non valido: campo obbligatorio mancante: classePriorita");
            }
            if (!admin.has("generaPromemoria")) {
                throw new Exception("JSON non valido: campo obbligatorio mancante: generaPromemoria");
            }

            String tipologia = admin.get("tipologiaPrescrizione").asText();
            JsonNode sensibili = prescrizioni.path("datiSensibili");

            if (tipologia.equals("02")) {
                if(!sensibili.has("testoQuesitoDiagnostico") && !sensibili.has("codQuesitoDiagnostico")) {
                    throw new Exception("Per la visita specialistica serve almeno uno tra testoQuesitoDiagnostico e codQuesitoDiagnostico");
                }

                JsonNode prestazioniSpec = sensibili.path("elencoPrestazioni").path("prestazioniSpecialistiche");
                if (prestazioniSpec.isArray()) {
                    for (JsonNode prest : prestazioniSpec) {
                        if (!prest.has("codicePrestazione")) {
                            throw new Exception("codicePrestazione SISS mancante in una prestazione specialistica");
                        }
                    }
                }
            }
        }
    }
}


