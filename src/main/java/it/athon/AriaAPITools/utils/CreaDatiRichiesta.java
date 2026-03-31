package it.athon.AriaAPITools.utils;

import java.util.List;

import it.athon.AriaAPITools.model.DatiRichiesta;
import it.athon.AriaAPITools.model.DatiCittadino;
import it.athon.AriaAPITools.model.DatiPrescrizione;


public class CreaDatiRichiesta {    

    public DatiRichiesta creaDatiRichiesta(String idRichiesta, DatiCittadino cittadino, List<DatiPrescrizione> prescrizioni) {

        DatiRichiesta datiRichiesta = new DatiRichiesta();

        datiRichiesta.setIdRichiesta(idRichiesta);
        datiRichiesta.setDatiCittadino(cittadino);
        datiRichiesta.setPrescrizioni(prescrizioni);

        return datiRichiesta;
    }
}
