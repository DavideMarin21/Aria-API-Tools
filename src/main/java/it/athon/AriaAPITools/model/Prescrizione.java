package it.athon.AriaAPITools.model;


public class Prescrizione {

    private String progressivoPrescrizione;
    private DatiAmministrativi datiAmministrativi;
    private DatiSensibili datiSensibili;

    public String getProgressivoPrescrizione() {
        return progressivoPrescrizione;
    }
    public void setProgressivoPrescrizione(String progressivoPrescrizione) {
        this.progressivoPrescrizione = progressivoPrescrizione;
    }
    public DatiAmministrativi getDatiAmministrativi() {
        return datiAmministrativi;
    }
    public void setDatiAmministrativi(DatiAmministrativi datiAmministrativi) {
        this.datiAmministrativi = datiAmministrativi;
    }
    public DatiSensibili getDatiSensibili() {
        return datiSensibili;
    }
    public void setDatiSensibili(DatiSensibili datiSensibili) {
        this.datiSensibili = datiSensibili;
    }

    
    
}
