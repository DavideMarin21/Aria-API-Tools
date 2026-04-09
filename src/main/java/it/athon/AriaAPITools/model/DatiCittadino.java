package it.athon.AriaAPITools.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//  FORZO L'ORDINE DALL'ALTO VERSO IL BASSO
@JsonPropertyOrder({ 
    "idCittadinoSTP",
    "codiceFiscale",
    "numIdentPers", 
    "cognome", 
    "nome", 
    "sesso", 
    "ASLAssistito", 
    "provAssistito" 
})

public class DatiCittadino {
    
    private String idCittadinoSTP;
    private String codiceFiscale;
    private String numIdentPers;
    private String cognome;
    private String nome;
    private String sesso;
    private String eta;
    private String indirizzoDomicilio;
    private String civicoDomicilio;
    private String idComuneDomicilio;
    private String comuneDomicilio;
    private String CAPDomicilio;
    private String provinciaDomicilio;
    private String numTessSasn;
    private String socNavigaz;
    private String istituzCompetente;
    private String numeroTesseraEuropea;
    private String dataNascitaAssIstEstera;
    private String dataScadenzaTesseraEuropea;
    private String siglaStatoEstero;
    @JsonProperty("ASLAssistito")
    private String ASLAssistito;
    @JsonProperty("provAssistito")
    private String provAssistito;
    private ElencoEsenzioni elencoEsenzioni;

    public DatiCittadino() {}

    public String getIdCittadinoSTP() {
        return idCittadinoSTP;
    }
    public void setIdCittadinoSTP(String idCittadinoSTP) {
        this.idCittadinoSTP = idCittadinoSTP;
    }
    public String getCodiceFiscale() {
        return codiceFiscale;
    }
    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }
    public String getNumIdentPers() {
        return numIdentPers;
    }
    public void setNumIdentPers(String numIdentPers) {
        this.numIdentPers = numIdentPers;
    }
    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSesso() {
        return sesso;
    }
    public void setSesso(String sesso) {
        this.sesso = sesso;
    }
    public String getEta() {
        return eta;
    }
    public void setEta(String eta) {
        this.eta = eta;
    }
    public String getIndirizzoDomicilio() {
        return indirizzoDomicilio;
    }
    public void setIndirizzoDomicilio(String indirizzoDomicilio) {
        this.indirizzoDomicilio = indirizzoDomicilio;
    }
    public String getCivicoDomicilio() {
        return civicoDomicilio;
    }
    public void setCivicoDomicilio(String civicoDomicilio) {
        this.civicoDomicilio = civicoDomicilio;
    }
    public String getIdComuneDomicilio() {
        return idComuneDomicilio;
    }
    public void setIdComuneDomicilio(String idComuneDomicilio) {
        this.idComuneDomicilio = idComuneDomicilio;
    }
    public String getComuneDomicilio() {
        return comuneDomicilio;
    }
    public void setComuneDomicilio(String comuneDomicilio) {
        this.comuneDomicilio = comuneDomicilio;
    }
    public String getCAPDomicilio() {
        return CAPDomicilio;
    }
    public void setCAPDomicilio(String cAPDomicilio) {
        CAPDomicilio = cAPDomicilio;
    }
    public String getProvinciaDomicilio() {
        return provinciaDomicilio;
    }
    public void setProvinciaDomicilio(String provinciaDomicilio) {
        this.provinciaDomicilio = provinciaDomicilio;
    }
    public String getNumTessSasn() {
        return numTessSasn;
    }
    public void setNumTessSasn(String numTessSasn) {
        this.numTessSasn = numTessSasn;
    }
    public String getSocNavigaz() {
        return socNavigaz;
    }
    public void setSocNavigaz(String socNavigaz) {
        this.socNavigaz = socNavigaz;
    }
    public String getIstituzCompetente() {
        return istituzCompetente;
    }
    public void setIstituzCompetente(String istituzCompetente) {
        this.istituzCompetente = istituzCompetente;
    }
    public String getNumeroTesseraEuropea() {
        return numeroTesseraEuropea;
    }
    public void setNumeroTesseraEuropea(String numeroTesseraEuropea) {
        this.numeroTesseraEuropea = numeroTesseraEuropea;
    }
    public String getDataNascitaAssIstEstera() {
        return dataNascitaAssIstEstera;
    }
    public void setDataNascitaAssIstEstera(String dataNascitaAssIstEstera) {
        this.dataNascitaAssIstEstera = dataNascitaAssIstEstera;
    }
    public String getDataScadenzaTesseraEuropea() {
        return dataScadenzaTesseraEuropea;
    }
    public void setDataScadenzaTesseraEuropea(String dataScadenzaTesseraEuropea) {
        this.dataScadenzaTesseraEuropea = dataScadenzaTesseraEuropea;
    }
    public String getSiglaStatoEstero() {
        return siglaStatoEstero;
    }
    public void setSiglaStatoEstero(String siglaStatoEstero) {
        this.siglaStatoEstero = siglaStatoEstero;
    }
    public String getASLAssistito() {
        return ASLAssistito;
    }
    public void setASLAssistito(String aSLAssistito) {
        ASLAssistito = aSLAssistito;
    }
    public String getProvAssistito() {
        return provAssistito;
    }
    public void setProvAssistito(String provAssistito) {
        this.provAssistito = provAssistito;
    }
    public ElencoEsenzioni getElencoEsenzioni() {
        return elencoEsenzioni;
    }
    public void setElencoEsenzioni(ElencoEsenzioni elencoEsenzioni) {
        this.elencoEsenzioni = elencoEsenzioni;
    }


    
}
