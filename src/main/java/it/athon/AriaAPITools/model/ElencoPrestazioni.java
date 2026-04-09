package it.athon.AriaAPITools.model;

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
