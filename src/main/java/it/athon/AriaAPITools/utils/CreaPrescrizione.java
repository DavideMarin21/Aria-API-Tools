package it.athon.AriaAPITools.utils;
import it.athon.AriaAPITools.model.DatiSensibili;
import it.athon.AriaAPITools.model.DatiAmministrativi;
import it.athon.AriaAPITools.model.Prescrizione;

public class CreaPrescrizione {

    public Prescrizione creaPrescrizione(String progressivoPrescrizione, DatiAmministrativi datiAmministrativi, DatiSensibili datiSensibili) {

        Prescrizione prescrizione = new Prescrizione();

        prescrizione.setProgressivoPrescrizione(progressivoPrescrizione);
        prescrizione.setDatiAmministrativi(datiAmministrativi);
        prescrizione.setDatiSensibili(datiSensibili);

        return prescrizione;
    }


    
}
