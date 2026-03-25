package it.athon.AriaAPITools.utils;
import it.athon.AriaAPITools.model.PrestazioneSpecialistica;

public class CreaPrestazioniSpecialistiche {
    
    public PrestazioneSpecialistica creaPrestazioneSpecialistica(String codicePrestazione, String descrizionePrestazione, String quantitaPrestazione) {

        PrestazioneSpecialistica prestazioneSpecialistica = new PrestazioneSpecialistica();

        prestazioneSpecialistica.setCodicePrestazione(codicePrestazione);
        prestazioneSpecialistica.setDescrizionePrestazione(descrizionePrestazione);
        prestazioneSpecialistica.setQuantitaPrestazione(quantitaPrestazione);

        return prestazioneSpecialistica;
    }
}
