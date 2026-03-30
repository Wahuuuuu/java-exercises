package prog2.model;

public class Bungalow extends Casa{
    protected int placesParquing;
    protected boolean terrassa, tv, aireFred;
    {
        estadaMinimaBaixa = 4;
        estadaMinimaAlta = 7;
    }


    // Constructor
    //-------------------------
    public Bungalow(String nom, String idAllotjaments, boolean operatiu, String iluminacio, float mida, int habitacions, int placesPersones,
                    int placesParquing, boolean terrassa, boolean tv, boolean aireFred) {
        super(nom, idAllotjaments, operatiu, iluminacio, mida, habitacions, placesPersones);
        this.placesParquing = placesParquing;
        this.terrassa = terrassa;
        this.tv = tv;
        this.aireFred = aireFred;
    }


    // getters and setters:
    // -----------------------
    public int getPlacesParquing() { return this.placesParquing; }
    public void setPlacesParquing(int placesParquing) { this.placesParquing = placesParquing; }

    public boolean getTerrassa() { return this.terrassa; }
    public void setTerrassa(boolean terrassa) { this.terrassa = terrassa; }

    public boolean getTv() { return this.tv; }
    public void setTv(boolean tv) { this.tv = tv; }

    public boolean getAireFred() { return this.aireFred; }
    public void setAireFred(boolean aireFred) { this.aireFred = aireFred; }


    // other methods:
    // -------------------------
    @Override
    public boolean correcteFuncionament() { return this.aireFred; }

    @Override
    public String toString() {
        return (
                super.toString()
              + ", places de pàrquing: " + this.placesParquing
              + ", terrasa, tv i airefred: " + this.terrassa + ", " + this.tv + ", " + this.aireFred
                );
    }
}
