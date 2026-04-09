package it.athon.AriaAPITools.model;

// import lombok.AllArgsConstructor;
// import lombok.Builder;
// import lombok.Data;
// import lombok.NoArgsConstructor;

// @Data
// @Builder
// @NoArgsConstructor
// @AllArgsConstructor

public class DatiOperatore {

    private String nomeOperatore;
    private String cognomeOperatore;
    private String codiceFiscaleOperatore;

    public DatiOperatore(){}
    
    public String getNomeOperatore() {
        return nomeOperatore;
    }
    public void setNomeOperatore(String nomeOperatore) {
        this.nomeOperatore = nomeOperatore;
    }
    public String getCognomeOperatore() {
        return cognomeOperatore;
    }
    public void setCognomeOperatore(String cognomeOperatore) {
        this.cognomeOperatore = cognomeOperatore;
    }
    public String getCodiceFiscaleOperatore() {
        return codiceFiscaleOperatore;
    }
    public void setCodiceFiscaleOperatore(String codiceFiscaleOperatore) {
        this.codiceFiscaleOperatore = codiceFiscaleOperatore;
    }
    
}
