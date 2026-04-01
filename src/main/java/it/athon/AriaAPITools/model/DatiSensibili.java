package it.athon.AriaAPITools.model;


public class DatiSensibili {
    
    private String testoQuesitoDiagnostico;
    private String codQuesitoDiagnostico;
    private String flagEsenzionePatologia;
    private String codiceEsenzione;
    private String flagAssenzaEsenzioni;
    private String flagEsenzioniReddito;
    private String flagRiservata;
    private String flagStampaIniziali;
    private Oscuramento oscuramento;
    private ElencoPrestazioni elencoPrestazioni;

    public String getTestoQuesitoDiagnostico() {
        return testoQuesitoDiagnostico;
    }
    public void setTestoQuesitoDiagnostico(String testoQuesitoDiagnostico) {
        this.testoQuesitoDiagnostico = testoQuesitoDiagnostico;
    }
    public String getCodQuesitoDiagnostico() {
        return codQuesitoDiagnostico;
    }
    public void setCodQuesitoDiagnostico(String codQuesitoDiagnostico) {
        this.codQuesitoDiagnostico = codQuesitoDiagnostico;
    }
    public String getFlagEsenzionePatologia() {
        return flagEsenzionePatologia;
    }
    public void setFlagEsenzionePatologia(String flagEsenzionePatologia) {
        this.flagEsenzionePatologia = flagEsenzionePatologia;
    }
    public String getCodiceEsenzione() {
        return codiceEsenzione;
    }
    public void setCodiceEsenzione(String codiceEsenzione) {
        this.codiceEsenzione = codiceEsenzione;
    }
    public String getFlagAssenzaEsenzioni() {
        return flagAssenzaEsenzioni;
    }
    public void setFlagAssenzaEsenzioni(String flagAssenzaEsenzioni) {
        this.flagAssenzaEsenzioni = flagAssenzaEsenzioni;
    }
    public String getFlagEsenzioniReddito() {
        return flagEsenzioniReddito;
    }
    public void setFlagEsenzioniReddito(String flagEsenzioniReddito) {
        this.flagEsenzioniReddito = flagEsenzioniReddito;
    }
    public String getFlagRiservata() {
        return flagRiservata;
    }
    public void setFlagRiservata(String flagRiservata) {
        this.flagRiservata = flagRiservata;
    }
    public String getFlagStampaIniziali() {
        return flagStampaIniziali;
    }
    public void setFlagStampaIniziali(String flagStampaIniziali) {
        this.flagStampaIniziali = flagStampaIniziali;
    }
    public Oscuramento getOscuramento() {
        return oscuramento;
    }
    public void setOscuramento(Oscuramento oscuramento) {
        this.oscuramento = oscuramento;
    }
    public ElencoPrestazioni getElencoPrestazioni() {
        return elencoPrestazioni;
    }
    public void setElencoPrestazioni(ElencoPrestazioni elencoPrestazioni) {
        this.elencoPrestazioni = elencoPrestazioni;
    }

}
