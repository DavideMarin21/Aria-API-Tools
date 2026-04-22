package it.athon.AriaAPITools.utils;

import jakarta.xml.soap.*;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.w3c.dom.NodeList;


/**
 * Classe per la creazione del messaggio SOAP XML
 * Supporta l'uso del codiceFiscale, idAna o idAssistito
 * Deve essere dato anche il codice della tessera sanitaria
 */

public class CreaIdentificaCittadinoRequest {

    /**
     * Aggiunge i dati di ricerca tramite Codice Fiscale.
     * @param soapMessage Il messaggio SOAP precedentemente.
     * @param token Il token necessario per farsi accettare il messaggio SOAP
     * @param codiceFiscale Il CF del cittadino da ricercare.
     * @param idAna Il codice ANA 
     * @param idAssistito codice assistito della regione lombardia
     * @param codiceTs Il numero della Tessera Sanitario necessario per l'anagrafica completa
     * @return Il messaggio aggiornato.
     * @throws Exception errore nella creazione del SOAP/XML.
     */

    private static final Logger logger = LoggerFactory.getLogger(CreaIdentificaCittadinoRequest.class);

    // Metodo per creare il messaggio SOAP
    public SOAPMessage createBaseMessage() throws Exception {

        // Creo il messaggio SOAP XML
        logger.info("Creo il messaggio XML SOAP");
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();

        SOAPPart soapPart = soapMessage.getSOAPPart();
        SOAPEnvelope envelope = soapPart.getEnvelope();

        // Aggiungo la parte di Envelope
        logger.info("Aggiungo la parte di Envelope al messaggio SOAP");
        envelope.addNamespaceDeclaration("SOAP-ENC", "http://schemas.xmlsoap.org/soap/encoding/");
        envelope.addNamespaceDeclaration("xsd", "http://www.w3.org/1999/XMLSchema");
        envelope.addNamespaceDeclaration("xsi", "http://www.w3.org/1999/XMLSchema-instance");
        envelope.setAttribute("SOAP-ENV:encodingStyle", "http://schemas.xmlsoap.org/soap/encoding/");

        soapMessage.setProperty(SOAPMessage.WRITE_XML_DECLARATION, "true");
        soapMessage.setProperty(SOAPMessage.CHARACTER_SET_ENCODING, "ISO-8859-1");
        
        return soapMessage;
    }

    // Metodo per aggiungere Header al messaggio SOAP
    public SOAPMessage addHeader(SOAPMessage soapMessage, String token) throws Exception {

        logger.info("Aggiungo il token al messaggio SOAP");
        
        SOAPPart soapPart = soapMessage.getSOAPPart();
        SOAPEnvelope envelope = soapPart.getEnvelope();
        SOAPHeader header = envelope.getHeader();
        String appContextNamespace = "http://www.crs.lombardia.it/schemas/mw/2004-01/appcontext/";
        SOAPElement appContext = header.addChildElement("AppContext", "a", appContextNamespace);  
        SOAPElement automaticProcedureToken = appContext.addChildElement("AutomaticProcedureToken");
        automaticProcedureToken.addTextNode(token);

        logger.info("Ho aggiunto il token al messaggio SOAP");

        return soapMessage;
    }

    // Metodo per aggiungere il tag param al messaggio SOAP
    private SOAPElement creaNodoParametroBase(SOAPMessage soapMessage) throws Exception {

        logger.info("Aggiungo il tag param al messaggio SOAP");
        
        SOAPBody soapBody = soapMessage.getSOAPBody();
        String namespaceUriMetodo = "http://www.crs.lombardia.it/schemas/DCSanita/ICCE/2025-01/identificaCittadinoEsteso/";
        SOAPElement identificaMetodo = soapBody.addChildElement("ICCE.identificaCittadinoEsteso", "m", namespaceUriMetodo);
        identificaMetodo.setAttribute("dataSetVersion", "3.0");

        logger.info("Ho aggiunto il tag param al messaggio SOAP");

        return identificaMetodo.addChildElement("param");

    }

    // Metodo per aggiungere il CF al messaggio SOAP
    public SOAPMessage addBodyIdentificaCittaddino_CF(SOAPMessage soapMessage, String codiceFiscale, String codiceTs) throws Exception {

        logger.info("Creo la richiesta secondo il codice fiscale");

        SOAPElement param = creaNodoParametroBase(soapMessage);
        SOAPElement profiloCittadino = param.addChildElement("profiloCittadino");
        profiloCittadino.addChildElement("codiceTs").addTextNode(codiceTs);
        profiloCittadino.addChildElement("codiceFiscale").addTextNode(codiceFiscale);

        return soapMessage;

    }

    // Metodo per aggiungere idANA al messaggio SOAP
    public SOAPMessage addBodyIdentificaCittaddino_idANA(SOAPMessage soapMessage, String idANA, String codiceTs) throws Exception {

        logger.info("Creo la richiesta secondo il codice idAna");

        SOAPElement param = creaNodoParametroBase(soapMessage);
        SOAPElement profiloCittadino = param.addChildElement("profiloCittadino");
        profiloCittadino.addChildElement("codiceTs").addTextNode(codiceTs);
        profiloCittadino.addChildElement("idAna").addTextNode(idANA);

        return soapMessage;

    }

    // Metodo per aggiungere l'idAssistito al messaggio SOAP
    public SOAPMessage addBodyIdentificaCittaddino_idAssistito(SOAPMessage soapMessage, String idAssistito, String codiceTs) throws Exception {

        logger.info("Creo la richiesta secondo il codice idAssistito");

        SOAPElement param = creaNodoParametroBase(soapMessage);
        SOAPElement profiloCittadino = param.addChildElement("profiloCittadino");
        profiloCittadino.addChildElement("codiceTs").addTextNode(codiceTs);
        profiloCittadino.addChildElement("idAssistito").addTextNode(idAssistito);

        return soapMessage;

    }

    // Metodo per aggiungere codiceSesso, cognome e data di nascita
    public SOAPMessage addBodyIdentificaCittadino_SCdN(SOAPMessage soapMessage, String codiceSesso, String Cognome, String dataNascita, String codiceTs) throws Exception {

        logger.info("Creo la richiesta secondo codice Sesso, Cognome e data di Nascita");

        SOAPElement param = creaNodoParametroBase(soapMessage);
        SOAPElement profiloCittadino = param.addChildElement("profiloCittadino");
        profiloCittadino.addChildElement("codiceTs").addTextNode(codiceTs);
        profiloCittadino.addChildElement("cognome").addTextNode(Cognome);
        profiloCittadino.addChildElement("codiceSesso").addTextNode(codiceSesso);
        profiloCittadino.addChildElement("dataNascita").addTextNode(dataNascita);

        return soapMessage;

    }

    // Metodo per aggiungere codiceSesso, cognome e nome
    public SOAPMessage addBodyIdentificaCittadino_SCN(SOAPMessage soapMessage, String codiceSesso, String Cognome, String Nome, String codiceTs) throws Exception {

        logger.info("Creo la richiesta secondo codice Sesso, Cognome e data di Nascita");

        SOAPElement param = creaNodoParametroBase(soapMessage);
        SOAPElement profiloCittadino = param.addChildElement("profiloCittadino");
        profiloCittadino.addChildElement("codiceTs").addTextNode(codiceTs);
        profiloCittadino.addChildElement("cognome").addTextNode(Cognome);
        profiloCittadino.addChildElement("dataNascita").addTextNode(Nome);
        profiloCittadino.addChildElement("codiceSesso").addTextNode(codiceSesso);

        return soapMessage;

    }

    // Metodo per aggiungere gli attributi di ricerca
    public SOAPMessage addAttributiRicerca(SOAPMessage soapMessage, String pageNumber, String useWildcard, String maxRecords) throws Exception {

        logger.info("Aggiungo l'attributo di ricerca al messaggio SOAP");

        SOAPBody soapBody = soapMessage.getSOAPBody();

        // Cerco il nodo <param> creato in precedenza nel Body
        NodeList paramList = soapBody.getElementsByTagName("param");
        if (paramList.getLength() == 0) {
            throw new Exception("Nodo <param> non trovato! Devi aggiungere prima il Body del metodo.");
        }
        SOAPElement param = (SOAPElement) paramList.item(0);

        SOAPElement attributiRicerca = param.addChildElement("attributiRicerca");
        attributiRicerca.addChildElement("pageNumber").addTextNode(pageNumber);
        attributiRicerca.addChildElement("useWildcard").addTextNode(useWildcard);
        attributiRicerca.addChildElement("maxRecords").addTextNode(maxRecords);

        return soapMessage;

    }

    // Metodo per salvare il messaggio
    public SOAPMessage salvaMessaggio(SOAPMessage soapMessage) throws Exception {
    
        soapMessage.saveChanges();

        logger.info("Ho creato il messagio SOAP");

        return soapMessage;
    }

    // public SOAPMessage createIdentidicaCittadinoRequest(String valore_campo, String codiceTs) throws Exception{

    //     return createIdentificaCittadinoRequest(valore_campo, "CodiceFiscale", codiceTs);
    // }

    // public SOAPMessage createIdentificaCittadinoRequest(String valore_campo, String tipo_campo, String codiceTs) throws Exception {
        
    //     if (tipo_campo == null || tipo_campo.trim().isEmpty()) {
    //         tipo_campo = "CodiceFiscale";
    //     }

    //     // Creo il messaggio SOAP XML
    //     MessageFactory messageFactory = MessageFactory.newInstance();
    //     SOAPMessage soapMessage = messageFactory.createMessage();

    //     SOAPPart soapPart = soapMessage.getSOAPPart();
    //     SOAPEnvelope envelope = soapPart.getEnvelope();

    //     // Aggiungo la parte di Envelope
    //     envelope.addNamespaceDeclaration("SOAP-ENC", "http://schemas.xmlsoap.org/soap/encoding/");
    //     envelope.addNamespaceDeclaration("xsd", "http://www.w3.org/1999/XMLSchema");
    //     envelope.addNamespaceDeclaration("xsi", "http://www.w3.org/1999/XMLSchema-instance");
    //     envelope.setAttribute("SOAP-ENV:encodingStyle", "http://schemas.xmlsoap.org/soap/encoding/");

    //     // Aggiungo la parte di Header
    //     SOAPHeader header = envelope.getHeader();
    //     String appContextNamespace = "http://www.crs.lombardia.it/schemas/mw/2004-01/appcontext/";
    //     SOAPElement appContext = header.addChildElement("AppContext", "a", appContextNamespace);  
    //     SOAPElement automaticProcedureToken = appContext.addChildElement("AutomaticProcedureToken");
    //     automaticProcedureToken.addTextNode("prova");

    //     // Aggiungo la parte del Body
    //     SOAPBody soapBody = envelope.getBody();
    //     String namespaceUriMetodo = "http://www.crs.lombardia.it/schemas/DCSanita/ICCE/2025-01/identificaCittadinoEsteso/";
    //     SOAPElement identificaMetodo = soapBody.addChildElement("ICCE.identificaCittadinoEsteso", "m", namespaceUriMetodo);
    //     identificaMetodo.setAttribute("dataSetVersion", "3.0");

    //     // Aggiungo la parte dei parametri del Body
    //     SOAPElement param = identificaMetodo.addChildElement("param");
    //     SOAPElement profiloCittadino = param.addChildElement("profiloCittadino");
        
        
        
    //     // Usiamo uno switch per creare il tag XML corretto in base al tipo_campo
    //     switch (tipo_campo) {
    //         case "idAna":
    //             profiloCittadino.addChildElement("codiceTs").addTextNode(codiceTs);
    //             profiloCittadino.addChildElement("idAna").addTextNode(valore_campo);
    //             break;
    //         case "idAssistito":
    //             profiloCittadino.addChildElement("codiceTs").addTextNode(codiceTs);
    //             profiloCittadino.addChildElement("idAssistito").addTextNode(valore_campo);
    //             break;
    //         case "CodiceFiscale":
    //         default:
    //             profiloCittadino.addChildElement("codiceTs").addTextNode(codiceTs);
    //             profiloCittadino.addChildElement("codiceFiscale").addTextNode(valore_campo);
    //             break;
    //     }

    //     // Attributi di ricerca di default
    //     SOAPElement attributiRicerca = param.addChildElement("attributiRicerca");
    //     attributiRicerca.addChildElement("pageNumber").addTextNode("1");
    //     attributiRicerca.addChildElement("useWildcard").addTextNode("4");
    //     attributiRicerca.addChildElement("maxRecords").addTextNode("100");

    //     // Forza la stampa del tag <?xml version="1.0" ... ?>
    //     soapMessage.setProperty(SOAPMessage.WRITE_XML_DECLARATION, "true");
    //     // Imposta la codifica richiesta
    //     soapMessage.setProperty(SOAPMessage.CHARACTER_SET_ENCODING, "ISO-8859-1");

    //     soapMessage.saveChanges();
        
    //     return soapMessage;
    // }

}
