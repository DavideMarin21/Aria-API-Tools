package it.athon.AriaAPITools.utils;
import it.athon.AriaAPITools.model.DatiSensibili;
import it.athon.AriaAPITools.model.ElencoPrestazioni;

public class CreaDatiSensibili {
    public DatiSensibili creaDatiSensibili(String testoQuesitoDiagnostico, ElencoPrestazioni elencoPrestazioni) {

        DatiSensibili datiSensibili = new DatiSensibili();

        datiSensibili.setTestoQuesitoDiagnostico(testoQuesitoDiagnostico);
        datiSensibili.setElencoPrestazioni(elencoPrestazioni);

        return datiSensibili;
    }
}
