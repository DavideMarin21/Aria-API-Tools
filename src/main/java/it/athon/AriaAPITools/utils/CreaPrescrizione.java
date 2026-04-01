package it.athon.AriaAPITools.utils;
import it.athon.AriaAPITools.model.DatiSensibili;
import it.athon.AriaAPITools.model.DatiAmministrativi;
import it.athon.AriaAPITools.model.DatiPrescrizione;

public class CreaPrescrizione {

    public DatiPrescrizione creaPrescrizione(String progressivoPrescrizione, DatiAmministrativi datiAmministrativi, DatiSensibili datiSensibili) {

        DatiPrescrizione prescrizione = new DatiPrescrizione();

        prescrizione.setProgressivoPrescrizione(progressivoPrescrizione);
        prescrizione.setDatiAmministrativi(datiAmministrativi);
        prescrizione.setDatiSensibili(datiSensibili);

        return prescrizione;
    }


    
}
