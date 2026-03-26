package prog2.model;

public abstract class Casa extends Allotjament{
    protected String mida;  // Is it better using ENUM?
    protected int habitacions;
    protected int placesPersones;


    // Constructor:
    // ----------------------------
    public Casa(String nom, String idAllotjaments, String mida, int habitacions, int placesPersones) {
        super(nom, idAllotjaments);
        this.mida = mida;
        this.habitacions = habitacions;
        this.placesPersones = placesPersones;
    }


    // Getters and setters:
    // ---------------------------
    public String getMida() { return this.mida; }
    public void setMida(String mida) { this.mida = mida; }

    public int getHabitacions() { return this.habitacions; }
    public void setHabitacions(int habitacions) { this.habitacions = habitacions; }

    public int getPlacesPersones() { return this.placesPersones; }
    public void setPlacesPersones(int placesPersones) { this.placesPersones = placesPersones; }

}
