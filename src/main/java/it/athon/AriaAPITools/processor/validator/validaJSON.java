package it.athon.AriaAPITools.processor.validator;

/**
 * Questa classe permette di validare il JSON creato, verificando che contenga i campi richiesti a seconda dei dati presenti
 */

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import it.athon.AriaAPITools.exceptions.ValidazionePrescrizioneException;

public class validaJSON {

    private static final Logger logger = LoggerFactory.getLogger(validaJSON.class);

    private static final ObjectMapper mapper = new ObjectMapper();
    
    public static void validaJsonRichiesta(String jsonString) throws Exception {

        JsonNode root = mapper.readTree(jsonString);

        // Validazione dei campi appl e idStruttura

        if (!root.has("appl")) {
            throw new ValidazionePrescrizioneException("JSON non valido: campo obbligatorio mancante: appl");
        }
        logger.debug("Appl validato");

        if (!root.has("idStruttura")) {
            throw new ValidazionePrescrizioneException("JSON non valido: campo obbligatorio mancante: idStruttura");
        }
        logger.debug("idStruttura validato");

        // Validazione del campo relativo all'operatore
        if (!root.has("datiOperatore")) {
            throw new ValidazionePrescrizioneException("JSON non valido: campo obbligatorio mancante: datiOperatore");
        }
        else {
            JsonNode operatore = root.path("datiOperatore");
            if (!operatore.has("nomeOperatore")) {
                throw new ValidazionePrescrizioneException("JSON non valido: campo obbligatorio mancante: nomeOperatore");
            }
            if (!operatore.has("cognomeOperatore")) {
                throw new ValidazionePrescrizioneException("JSON non valido: campo obbligatorio mancante: cognomeOperatore");
            }
            if (!operatore.has("codiceFiscaleOperatore")) {
                throw new ValidazionePrescrizioneException("JSON non valido: campo obbligatorio mancante: codiceFiscaleOperatore");
            }
        }
        logger.debug("datiOperatore validato");
        
        // Validazione del campo relativo a datiRichiesta
        if (!root.has("datiRichiesta")) {
            throw new ValidazionePrescrizioneException("JSON non valido: campo obbligatorio mancante: datiRichiesta");
        }
        else {
            JsonNode datiRichiesta = root.path("datiRichiesta");
            for (JsonNode foglia : datiRichiesta) {
                JsonNode id = foglia.path("idRichiesta");
                if (id.isMissingNode()) {
                    throw new ValidazionePrescrizioneException("JSON non valido: campo obbligatorio mancante: idRichiesta");
                }
                JsonNode cittadino = foglia.path("datiCittadino");

                if (cittadino.isMissingNode()) {
                    throw new ValidazionePrescrizioneException("JSON non valido: campo obbligatorio mancante: datiCittadino");
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
                logger.debug("Dati cittadino validati");

                validaPrescrizioni(prescrizioni);
                logger.debug("Prescrizioni validate");
            }

        }
        logger.debug("datiRichiesta validato");
    }

    private static void validaCittadino(JsonNode cittadino, String tipoRicetta) throws ValidazionePrescrizioneException {

        // Regola fissa tipoModulo = 09 -> Nome e Cognome obbligatori

        if (!cittadino.has("nome")) {
            throw new ValidazionePrescrizioneException ("JSON non valido: campo obbligatorio mancante: nome cittadino");
        }
        if (!cittadino.has("cognome")) {
            throw new ValidazionePrescrizioneException("JSON non valido: campo obbligatorio mancante: cognome cittadino");
        }

        // Ora guardo il tipo di ricetta:
        // tipoRicetta vuota -> Assistito del SSN/SSR -> Codice Fiscale obbligatorio
        if (tipoRicetta.isEmpty()) {
            if (!cittadino.has("codiceFiscale")) {
                throw new ValidazionePrescrizioneException("JSON non valido: campo obbligatorio mancante: codiceFiscale cittadino");
            }
        } else if (tipoRicetta.equals("NA") || tipoRicetta.equals("ND")) {
            // Assistito SASN Italiano -> Codice fiscale, numero tessera sanitaria e società di navigazione obbligatori
            if (!cittadino.has("codiceFiscale")) {
                throw new ValidazionePrescrizioneException("JSON non valido: campo obbligatorio mancante: codiceFiscale cittadino per ricetta NA/ND");
            }
            if (!cittadino.has("numTessSasn")) {
                throw new ValidazionePrescrizioneException("JSON non valido: campo obbligatorio mancante: numTessSasn per ricetta NA/ND");
            }
            if (!cittadino.has("socNavigaz")) {
                throw new ValidazionePrescrizioneException("JSON non valido: campo obbligatorio mancante: socNavigaz per ricetta NA/ND");
            }
        } else if (tipoRicetta.equals("ST")) {
            // Assistito STP -> idCittadinoSTP obbligatorio
            if (!cittadino.has("idCittadinoSTP")) {
                throw new ValidazionePrescrizioneException("idCittadinoSTP obbligatorio per tipoRicetta ST");
            }
        } else if (tipoRicetta.equals("UE") || tipoRicetta.equals("EE") || tipoRicetta.equals("NE") || tipoRicetta.equals("NX")) {
            // Assistito estero -> numero identificativo persona, istituzione di appartenenza, data di nascita, 
            // sigla stato estero, numero tessera europea, data scadena tessera europea dati obbligatori
            if (!cittadino.has("numIdentPers")) {
                throw new ValidazionePrescrizioneException("JSON non valido: campo obbligatorio mancante: numIdentPers per ricetta UE/EE/NE/NX");
            }
            if (!cittadino.has("istituzCompetente")) {
                throw new ValidazionePrescrizioneException("JSON non valido: campo obbligatorio mancante: istituzCompetente per ricetta UE/EE/NE/NX");
            }
            if (!cittadino.has("dataNascitaAssistEstera")) {
                throw new ValidazionePrescrizioneException("JSON non valido: campo obbligatorio mancante: dataNascitaAssistEstera per ricetta UE/EE/NE/NX");
            }
            if (!cittadino.has("siglastatoEstero")) {
                throw new ValidazionePrescrizioneException("JSON non valido: campo obbligatorio mancante: siglastatoEstero per ricetta UE/EE/NE/NX");
            }
            if (!cittadino.has("numeroTesseraEuropea")) {
                throw new ValidazionePrescrizioneException("JSON non valido: campo obbligatorio mancante: numeroTesseraEuropea per ricetta UE/EE/NE/NX");
            }
            if (!cittadino.has("dataScadenzaTesseraEuropea")) {
                throw new ValidazionePrescrizioneException("JSON non valido: campo obbligatorio mancante: dataScadenzaTesseraEuropea per ricetta UE/EE/NE/NX");
            }
        }
    }

    private static void validaPrescrizioni (JsonNode prescrizioni) throws ValidazionePrescrizioneException {
        if (!prescrizioni.isArray() || prescrizioni.isEmpty()) return;

        for (JsonNode prescrizione : prescrizioni) {
            if (!prescrizione.has("progressivoPrescrizione")) {
                throw new ValidazionePrescrizioneException("Progressivo prescrizione mancante");
            }

            JsonNode admin = prescrizione.path("datiAmministrativi");
            if (!admin.has("tipoModulo") || !admin.get("tipoModulo").asText().equals("09")) {
                throw new ValidazionePrescrizioneException("Questo validatore supporta solo tipoModulo = 09");
            }

            //datiAmminstratore -> tipologia Prescrizione, tipo visita, flag ricetta elettronica, 
            // classe priorità, genera promemoria dati obbligatori
            if (!admin.has("tipologiaPrescrizione")) {
                throw new ValidazionePrescrizioneException("JSON non valido: campo obbligatorio mancante: tipologiaPrescrizione");
            }
            if (!admin.has("tipoVisita")) {
                throw new ValidazionePrescrizioneException("JSON non valido: campo obbligatorio mancante: tipoVisita");    
            }
            if (!admin.has("flagRicEl")) {
                throw new ValidazionePrescrizioneException("JSON non valido: campo obbligatorio mancate: flagRiceEl");
            }
            if (!admin.has("classePriorita")) {
                throw new ValidazionePrescrizioneException("JSON non valido: campo obbligatorio mancante: classePriorita");
            }
            if (!admin.has("generaPromemoria")) {
                throw new ValidazionePrescrizioneException("JSON non valido: campo obbligatorio mancante: generaPromemoria");
            }

            String tipologia = admin.get("tipologiaPrescrizione").asText();
            JsonNode sensibili = prescrizione.path("datiSensibili");

            if (tipologia.equals("02")) {
                if(!sensibili.has("testoQuesitoDiagnostico") && !sensibili.has("codQuesitoDiagnostico")) {
                    throw new ValidazionePrescrizioneException("Per la visita specialistica serve almeno uno tra testoQuesitoDiagnostico e codQuesitoDiagnostico");
                }

                JsonNode prestazioniSpec = sensibili.path("elencoPrestazioni").path("prestazioniSpecialistiche");
                if (prestazioniSpec.isArray()) {
                    for (JsonNode prest : prestazioniSpec) {
                        if (!prest.has("codicePrestazione")) {
                            throw new ValidazionePrescrizioneException("codicePrestazione SISS mancante in una prestazione specialistica");
                        }
                    }
                }
            }
        }
    }
}


