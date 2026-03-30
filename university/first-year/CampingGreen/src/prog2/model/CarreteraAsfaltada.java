package prog2.model;

public class CarreteraAsfaltada extends AccesAsfalt {
    protected float pes;

    public CarreteraAsfaltada(String nom_, boolean accesibilitat_, float volum_, float pes_) {
        super(nom_, accesibilitat_, volum_);
        this.pes = pes_;
    }

    public float getPes() { return this.pes; }

    public void setPes(float pes_) { this.pes = pes_; }

    public String toString() {
        return ( this.volum + " metres quadrats d'asfalt, pes màxim " + this.pes + " kg" );
    }

    public boolean isAccessibilitat() {
        return true;
    }
}
