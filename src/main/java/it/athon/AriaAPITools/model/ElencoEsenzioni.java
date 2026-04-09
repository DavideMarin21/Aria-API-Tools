package it.athon.AriaAPITools.model;

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

