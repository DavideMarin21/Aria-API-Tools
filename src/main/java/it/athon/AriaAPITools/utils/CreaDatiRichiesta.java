package it.athon.AriaAPITools.utils;

import java.util.List;

import it.athon.AriaAPITools.model.DatiRichiesta;
import it.athon.AriaAPITools.model.DatiCittadino;
import it.athon.AriaAPITools.model.Prescrizione;


public class CreaDatiRichiesta {    

    public DatiRichiesta creaDatiRichiesta(String idRichiesta, DatiCittadino cittadino, List<Prescrizione> prescrizioni) {

        DatiRichiesta datiRichiesta = new DatiRichiesta();

        datiRichiesta.setIdRichiesta(idRichiesta);
        datiRichiesta.setDatiCittadino(cittadino);
        datiRichiesta.setPrescrizioni(prescrizioni);

        return datiRichiesta;
    }
}
