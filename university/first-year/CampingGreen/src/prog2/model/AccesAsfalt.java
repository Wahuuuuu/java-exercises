package prog2.model;

public abstract class AccesAsfalt extends Acces {
    protected float volum;  // volum d'asfalt en metres quadrats

    // Constructor
    public AccesAsfalt(String nom_, boolean accesibilitat_, float volum_) {
        super(nom_, accesibilitat_);
        this.volum = volum_;
    }

    // Methods

    public float getVolum() { return this.volum; }

    public void setVolum(float volum_) { this.volum = volum_; }

    public abstract boolean isAccessibilitat();

    public abstract String toString();
}
