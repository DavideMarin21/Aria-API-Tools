package it.athon.AriaAPITools.model;

/**
 * Modello di dati relativo a ElencoPrestazioni per la richiesta JSON
 */

import java.util.List;

public class ElencoPrestazioni {
    
    private List<PrestazioneSpecialistica> prestazioniSpecialistiche;
    
    public ElencoPrestazioni() {}
    
    public List<PrestazioneSpecialistica> getPrestazioniSpecialistiche() {
        return prestazioniSpecialistiche;
    }
    public void setPrestazioniSpecialistiche(List<PrestazioneSpecialistica> prestazioniSpecialistiche) {
        this.prestazioniSpecialistiche = prestazioniSpecialistiche;
    }
}
