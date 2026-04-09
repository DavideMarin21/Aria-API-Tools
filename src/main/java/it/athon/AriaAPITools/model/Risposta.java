package it.athon.AriaAPITools.model;

import java.util.List;

public class Risposta {

    private String esito;
    private String codiceErrore;
    private String descErrore;
    private List<DatiRisposta> datiRisposta;
    private List<Warning> listaWarning;
    private List<Eccezione> listaEccezioni;

    public Risposta() {}
    
    public String getEsito() {
        return esito;
    }
    public void setEsito(String esito) {
        this.esito = esito;
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
    public List<DatiRisposta> getDatiRisposta() {
        return datiRisposta;
    }
    public void setDatiRisposta(List<DatiRisposta> datiRisposta) {
        this.datiRisposta = datiRisposta;
    }
    public List<Warning> getListaWarning() {
        return listaWarning;
    }
    public void setListaWarning(List<Warning> listaWarning) {
        this.listaWarning = listaWarning;
    }
    public List<Eccezione> getListaEccezioni() {
        return listaEccezioni;
    }
    public void setListaEccezioni(List<Eccezione> listaEccezioni) {
        this.listaEccezioni = listaEccezioni;
    }

    
}
