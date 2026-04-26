package prog2.model;

public class CamiTerra extends AccesTerra {
    // constructor
    public CamiTerra (String nom_, boolean accesibilitat_, float longitud_) {
        super(nom_, accesibilitat_, longitud_);
    }

    // methods
    public boolean isAccessibilitat() { return false; }

    public String toString() {
        return ( "Longitud " + this.longitud + " metres");
    }
}
