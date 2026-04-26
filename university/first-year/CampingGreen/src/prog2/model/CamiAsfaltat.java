package prog2.model;

public class CamiAsfaltat extends AccesAsfalt {
    // constructor
    public CamiAsfaltat(String nom_, boolean accesibilitat_, float volum_) {
        super(nom_, accesibilitat_, volum_);
    }

    // methods
    public boolean isAccessibilitat() {return false;}

    public String toString() {
        return ( this.volum + " metres quadrats d'asfalt" );
    }
}
