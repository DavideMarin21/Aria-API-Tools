package it.athon.AriaAPITools.model;

/**
 * Modello di dati relativo a ElencoEsenzioni per la richiesta JSON
 */

import java.util.List;

public class ElencoEsenzioni {

    private List<String> codiceEsenzione;

    public ElencoEsenzioni() {}
    
    public List<String> getCodiceEsenzione() {
        return codiceEsenzione;
    }

    public void setCodiceEsenzione(List<String> codiceEsenzione) {
        this.codiceEsenzione = codiceEsenzione;
    }
}

