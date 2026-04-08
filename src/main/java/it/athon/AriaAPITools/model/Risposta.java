package it.athon.AriaAPITools.model;

import java.util.List;

public class Risposta {

    private String esito;
    private String codiceErrore;
    private String descErrore;
    private List<DatiRisposta> datiRisposta;
    private List<ListaWarning> listaWarning;
    private List<ListaEccezioni> listaEccezioni;
    
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
    public List<datiRisposta> getDatiRisposta() {
        return datiRisposta;
    }
    public void setDatiRisposta(List<datiRisposta> datiRisposta) {
        this.datiRisposta = datiRisposta;
    }
    public List<listaWarning> getListaWarning() {
        return listaWarning;
    }
    public void setListaWarning(List<listaWarning> listaWarning) {
        this.listaWarning = listaWarning;
    }
    public List<listaEccezioni> getListaEccezioni() {
        return listaEccezioni;
    }
    public void setListaEccezioni(List<listaEccezioni> listaEccezioni) {
        this.listaEccezioni = listaEccezioni;
    }

    
}
