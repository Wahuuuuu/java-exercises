package prog2.model;

public class Glamping extends Casa {
    private String material;
    private boolean casaMascota;
    {
        estadaMinimaAlta = estadaMinimaBaixa = 3;
    }


    public Glamping(String nom, String idAllotjaments, String mida, int habitacions, int placesPersones,
                    String material, boolean casaMascota) {
        super(nom, idAllotjaments, mida, habitacions, placesPersones);
        this.material = material;
        this.casaMascota = casaMascota;
    }


    // getters and setters
    // ---------------------------
    public String getMaterial() { return this.material; }
    public void setMaterial(String material) { this.material = material; }

    public boolean getCasaMascota() { return this.casaMascota; }
    public void setCasaMascota(boolean casaMascota) { this.casaMascota = casaMascota; }


    // other methods
    @Override
    public boolean correcteFuncionament() { return this.casaMascota; }
}
