package prog2.model;

public abstract class Casa extends Allotjament{
    protected float mida;
    protected int habitacions;
    protected int placesPersones;


    // Constructor:
    // ----------------------------
    public Casa(String nom, String idAllotjaments, boolean operatiu, String iluminacio, float mida, int habitacions, int placesPersones) {
        super(nom, idAllotjaments, operatiu, iluminacio);
        this.mida = mida;
        this.habitacions = habitacions;
        this.placesPersones = placesPersones;
    }


    // Getters and setters:
    // ---------------------------
    public float getMida() { return this.mida; }
    public void setMida(float mida) { this.mida = mida; }

    public int getHabitacions() { return this.habitacions; }
    public void setHabitacions(int habitacions) { this.habitacions = habitacions; }

    public int getPlacesPersones() { return this.placesPersones; }
    public void setPlacesPersones(int placesPersones) { this.placesPersones = placesPersones; }


    // Other methods:
    public String toString() {
        return (
                super.toString()
              + ", mida: " + this.mida
              + ", habitaciones: " + this.habitacions
              + ", placesPersones: " + this.placesPersones
                );
    }
}
