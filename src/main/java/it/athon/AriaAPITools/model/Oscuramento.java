package it.athon.AriaAPITools.model;

/**
 * Modello di dati relativo a Oscuramento per la richiesta JSON
 */

import java.util.List;

public class Oscuramento {
    
    private List<String> codiceCasualeOscuramento;

    public Oscuramento() {}

    public List<String> getCodiceCasualeOscuramento() {
        return codiceCasualeOscuramento;
    }

    public void setCodiceCasualeOscuramento(List<String> codiceCasualeOscuramento) {
        this.codiceCasualeOscuramento = codiceCasualeOscuramento;
    }

}
