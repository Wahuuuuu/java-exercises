package prog2.model;

public class BungalowPremium extends Bungalow {
    private boolean serveisExtra;
    private String codiWiFi;


    public BungalowPremium(String nom, String idAllotjaments, String mida, int habitacions, int placesPersones,
                           int placesParquing, boolean terrassa, boolean tv, boolean aireFred,
                           boolean serveisExtra, String codiWiFi) {
        super(nom, idAllotjaments, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        this.serveisExtra = serveisExtra;
        this.codiWiFi = codiWiFi;
    }


    // getters and setters
    // ---------------------------
    public boolean getServeisExtra() { return this.serveisExtra; }
    public void setServeisExtra(boolean serveisExtra) { this.serveisExtra = serveisExtra; }

    public String getCodiWiFi() { return this.codiWiFi; }
    public void setCodiWiFi(String codiWiFi) { this.codiWiFi = codiWiFi; }


    // other methods
    @Override
    public boolean correcteFuncionament() {
        int len = this.codiWiFi.length();
        return (8 <= len && len <= 16);
    }
}
