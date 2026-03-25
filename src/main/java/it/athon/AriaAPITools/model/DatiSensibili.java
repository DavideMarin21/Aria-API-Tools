package it.athon.AriaAPITools.model;


public class DatiSensibili {
    
    private String testoQuesitoDiagnostico;
    private ElencoPrestazioni elencoPrestazioni;

    public String getTestoQuesitoDiagnostico() {
        return testoQuesitoDiagnostico;
    }
    public void setTestoQuesitoDiagnostico(String testoQuesitoDiagnostico) {
        this.testoQuesitoDiagnostico = testoQuesitoDiagnostico;
    }
    public ElencoPrestazioni getElencoPrestazioni() {
        return elencoPrestazioni;
    }
    public void setElencoPrestazioni(ElencoPrestazioni elencoPrestazioni) {
        this.elencoPrestazioni = elencoPrestazioni;
    }

}
