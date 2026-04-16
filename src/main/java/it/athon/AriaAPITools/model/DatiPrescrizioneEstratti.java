package it.athon.AriaAPITools.model;

public class DatiPrescrizioneEstratti {

    private String nre;
    private String statoPrescrizione;
    private String pdfBase64;

    public DatiPrescrizioneEstratti(String nre, String statoPrescrizione, String pdfBase64) {
        this.nre = nre;
        this.pdfBase64 = pdfBase64;
        this.statoPrescrizione = statoPrescrizione;
    }

    public String getNre() {
        return nre;
    }
    // public void setNre(String nre) {
    //     this.nre = nre;
    // }

    public String getstatoPrescrizione() {
        return statoPrescrizione;
    }
    // public void setstatoPrescrizione(String nre) {
    //     this.statoPrescrizione = statoPrescrizione;
    // }

    public String getPdfBase64() {
        return pdfBase64;
    }
    // public void setPdfBase64(String pdfBase64) {
    //     this.pdfBase64 = pdfBase64;
    // }  
}
