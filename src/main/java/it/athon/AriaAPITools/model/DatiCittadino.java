package it.athon.AriaAPITools.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//  FORZO L'ORDINE DALL'ALTO VERSO IL BASSO
@JsonPropertyOrder({ 
    "codiceFiscale", 
    "cognome", 
    "nome", 
    "sesso", 
    "ASLAssistito", 
    "provAssistito" 
})

public class DatiCittadino {
    
    private String codiceFiscale;
    private String cognome;
    private String nome;
    private String sesso;

    @JsonProperty("ASLAssistito")
    private String ASLAssistito;

    @JsonProperty("provAssistito")
    private String provAssistito;

    public String getCodiceFiscale() {
        return codiceFiscale;
    }
    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
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

    @JsonProperty("ASLAssistito")
    public String getASLAssistito() {
        return ASLAssistito;
    }

    @JsonProperty("ASLAssistito")
    public void setASLAssistito(String aSLAssistito) {
        ASLAssistito = aSLAssistito;
    }
    public String getProvAssistito() {
        return provAssistito;
    }
    public void setProvAssistito(String provAssistito) {
        this.provAssistito = provAssistito;
    }
    
}
