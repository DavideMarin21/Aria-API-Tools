package it.athon.AriaAPITools.utils;
import java.util.List;

import it.athon.AriaAPITools.model.ElencoPrestazioni;
import it.athon.AriaAPITools.model.PrestazioneSpecialistica;

public class CreaElencoPrestazioni {

    public ElencoPrestazioni creaElencoPrestazioni(List<PrestazioneSpecialistica> prestazioniSpecialistiche) {

        ElencoPrestazioni elencoPrestazioni = new ElencoPrestazioni();
        elencoPrestazioni.setPrestazioniSpecialistiche(prestazioniSpecialistiche);

        return elencoPrestazioni;
    }
    
}
