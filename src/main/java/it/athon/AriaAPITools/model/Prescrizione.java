package it.athon.AriaAPITools.model;

import java.util.List;

public class Prescrizione {

    private String esitoOperazione;
    private String codiceErrore;
    private String descErrore;
    private String progressivoPrescrizione;
    private String identificativoUnivoco;
    private String statoPrescrizione;
    private String numeroRicettaElettronica;
    private String promemoriaRE;
    private String codiceAutentificazioneMEF;
    private List<DatiErogazione> datiErogazione;
    private String numeroSedute;
    private DatiAmministrativi datiAmministrativi;
    private DatiSensibili datiSensibili;
    private List<ListaWarning> listaWarning;
    private List<ListaEccezioni> listaEccezioni;
    
    public String getEsitoOperazione() {
        return esitoOperazione;
    }
    public void setEsitoOperazione(String esitoOperazione) {
        this.esitoOperazione = esitoOperazione;
    }
    public String getCodiceErrore() {
        return codiceErrore;
    }
    public void setCodiceErrore(String codiceErrore) {
        this.codiceErrore = codiceErrore;
    }
    public String getDescErrore() {
        return descErrore;
    }
    public void setDescErrore(String descErrore) {
        this.descErrore = descErrore;
    }
    public String getProgressivoPrescrizione() {
        return progressivoPrescrizione;
    }
    public void setProgressivoPrescrizione(String progressivoPrescrizione) {
        this.progressivoPrescrizione = progressivoPrescrizione;
    }
    public String getIdentificativoUnivoco() {
        return identificativoUnivoco;
    }
    public void setIdentificativoUnivoco(String identificativoUnivoco) {
        this.identificativoUnivoco = identificativoUnivoco;
    }
    public String getStatoPrescrizione() {
        return statoPrescrizione;
    }
    public void setStatoPrescrizione(String statoPrescrizione) {
        this.statoPrescrizione = statoPrescrizione;
    }
    public String getNumeroRicettaElettronica() {
        return numeroRicettaElettronica;
    }
    public void setNumeroRicettaElettronica(String numeroRicettaElettronica) {
        this.numeroRicettaElettronica = numeroRicettaElettronica;
    }
    public String getPromemoriaRE() {
        return promemoriaRE;
    }
    public void setPromemoriaRE(String promemoriaRE) {
        this.promemoriaRE = promemoriaRE;
    }
    public String getCodiceAutentificazioneMEF() {
        return codiceAutentificazioneMEF;
    }
    public void setCodiceAutentificazioneMEF(String codiceAutentificazioneMEF) {
        this.codiceAutentificazioneMEF = codiceAutentificazioneMEF;
    }
    public List<DatiErogazione> getDatiErogazione() {
        return datiErogazione;
    }
    public void setDatiErogazione(List<DatiErogazione> datiErogazione) {
        this.datiErogazione = datiErogazione;
    }
    public String getNumeroSedute() {
        return numeroSedute;
    }
    public void setNumeroSedute(String numeroSedute) {
        this.numeroSedute = numeroSedute;
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
    public List<ListaWarning> getListaWarning() {
        return listaWarning;
    }
    public void setListaWarning(List<ListaWarning> listaWarning) {
        this.listaWarning = listaWarning;
    }
    public List<ListaEccezioni> getListaEccezioni() {
        return listaEccezioni;
    }
    public void setListaEccezioni(List<ListaEccezioni> listaEccezioni) {
        this.listaEccezioni = listaEccezioni;
    }

    
}
