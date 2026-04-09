package it.athon.AriaAPITools.model;

public class Warning {
    
    private String codiceWarning;
    private String descWarning;
    private String nomeCampo;
    private String valoreCampo;
    private String descWarningCampo;
    private String codiceWarningCampo;
    private String ROI;

    public Warning() {}

    public String getCodiceWarning() {
        return codiceWarning;
    }

    public void setCodiceWarning(String codiceWarning) {
        this.codiceWarning = codiceWarning;
    }

    public String getDescWarning() {
        return descWarning;
    }

    public void setDescWarning(String descWarning) {
        this.descWarning = descWarning;
    }

    public String getNomeCampo() {
        return nomeCampo;
    }

    public void setNomeCampo(String nomeCampo) {
        this.nomeCampo = nomeCampo;
    }

    public String getValoreCampo() {
        return valoreCampo;
    }

    public void setValoreCampo(String valoreCampo) {
        this.valoreCampo = valoreCampo;
    }

    public String getDescWarningCampo() {
        return descWarningCampo;
    }

    public void setDescWarningCampo(String descWarningCampo) {
        this.descWarningCampo = descWarningCampo;
    }

    public String getCodiceWarningCampo() {
        return codiceWarningCampo;
    }

    public void setCodiceWarningCampo(String codiceWarningCampo) {
        this.codiceWarningCampo = codiceWarningCampo;
    }

    public String getROI() {
        return ROI;
    }

    public void setROI(String rOI) {
        ROI = rOI;
    }

    
}
