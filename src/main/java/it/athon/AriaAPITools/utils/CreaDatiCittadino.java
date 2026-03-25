package it.athon.AriaAPITools.utils;

import it.athon.AriaAPITools.model.DatiCittadino;

public class CreaDatiCittadino {

    public DatiCittadino creaDatiCittadino(String cfCittadino, String cognomeCittadino, String nomeCittadino, String sessoCittadino, String ASLCittadino, String provCittadino) {

        DatiCittadino cittadino = new DatiCittadino();

        cittadino.setCodiceFiscale(cfCittadino);
        cittadino.setCognome(cognomeCittadino);
        cittadino.setNome(nomeCittadino);
        cittadino.setSesso(sessoCittadino);
        cittadino.setASLAssistito(ASLCittadino);
        cittadino.setProvAssistito(provCittadino);

        return cittadino;

    }
    
}
