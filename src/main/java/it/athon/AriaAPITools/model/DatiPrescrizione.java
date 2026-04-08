package it.athon.AriaAPITools.model;


public class DatiPrescrizione {

    private String progressivoPrescrizione;
    private String abilitazioneDowngrade;
    private DatiAmministrativi datiAmministrativi;
    private DatiSensibili datiSensibili;

    public DatiPrescrizione() {}

    public String getProgressivoPrescrizione() {
        return progressivoPrescrizione;
    }
    public void setProgressivoPrescrizione(String progressivoPrescrizione) {
        this.progressivoPrescrizione = progressivoPrescrizione;
    }
    public String getAbilitazioneDowngrade() {
        return abilitazioneDowngrade;
    }
    public void setAbilitazioneDowngrade(String abilitazioneDowngrade) {
        this.abilitazioneDowngrade = abilitazioneDowngrade;
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
