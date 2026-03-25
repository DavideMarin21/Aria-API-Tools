package it.athon.AriaAPITools.utils;

import it.athon.AriaAPITools.model.DatiAmministrativi;

public class CreaDatiAmministrativi {

    public DatiAmministrativi creaDatiAmministrativi(String dataEmissione, String tipologiaPrescrizione, String tipoModulo, String tipoVisita, String flagSuggerita, String flagRicEl, String classePriorita, String flagRipetibile, String generaPromemoria) {

    DatiAmministrativi datiAmministrativi = new DatiAmministrativi();
    
        datiAmministrativi.setDataEmissione(dataEmissione);
        datiAmministrativi.setTipologiaPrescrizione(tipologiaPrescrizione);
        datiAmministrativi.setTipoModulo(tipoModulo);
        datiAmministrativi.setTipoVisita(tipoVisita);
        datiAmministrativi.setFlagSuggerita(flagSuggerita);
        datiAmministrativi.setFlagRicEl(flagRicEl);
        datiAmministrativi.setClassePriorita(classePriorita);
        datiAmministrativi.setFlagRipetibile(flagRipetibile);
        datiAmministrativi.setGeneraPromemoria(generaPromemoria);

        return datiAmministrativi;
    
    }   
}
